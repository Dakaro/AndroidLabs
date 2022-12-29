package com.example.zakupy

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.zakupy.Control.ApiInterface
import com.example.zakupy.Control.DatabaseControl
import com.example.zakupy.Control.RetrofitClient
import com.example.zakupy.databinding.ActivityMainBinding
import com.example.zakupy.model.providesRealmConfig
import com.google.gson.Gson
import io.realm.Realm
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    fun getProductList() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)

        print("probujemy \n")
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getAllProducts()
                print("ZWROCONA WARTOSC \n")
                //print(response.source().toString())
                print(response.string())
             /*   if (response.isSuccessful()) {
                    print(response.toString())
                    print("ESSA")

                    Gson().fromJson(response.toString(), ApiInterface::class.java)


                } else {
                    print("nie dziala")
                } */
            }catch (Ex:Exception){
                print("ZEPSUTE")
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Realm.init(this)

        runBlocking {
            var database: DatabaseControl = DatabaseControl(providesRealmConfig())

            // FIXTURKA DO WYWALENIA
            Realm.getInstance(providesRealmConfig()).beginTransaction()
            Realm.getInstance(providesRealmConfig()).deleteAll()
            Realm.getInstance(providesRealmConfig()).commitTransaction()

            database.insertProduct("jablko", null, "Poland")

            getProductList()
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