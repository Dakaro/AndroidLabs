package com.example.zakupy

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.zakupy.Control.DatabaseControl
import com.example.zakupy.databinding.ActivityMainBinding
import com.example.zakupy.model.providesRealmConfig
import io.realm.Realm
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Realm.init(this)

        runBlocking {
            var database: DatabaseControl = DatabaseControl(providesRealmConfig())

            // FIXTURKA DO WYWALENIA
            Realm.getInstance(providesRealmConfig()).beginTransaction()
            Realm.getInstance(providesRealmConfig()).deleteAll()
            Realm.getInstance(providesRealmConfig()).commitTransaction()

            database.insertProduct("jablko", null, "Poland")
        }

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)




    }
}