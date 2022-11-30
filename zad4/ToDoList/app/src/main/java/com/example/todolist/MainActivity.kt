package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.ui.main.MainViewModel
//import com.example.todolist.ui.main.ProductAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        /*
        val recyclerViewProduct = binding.rvProduct
        val productInstance = MainViewModel("nazwa1", "opis1", "data1", true)
        val productAdapter = ProductAdapter(productInstance)

        recyclerViewProduct.adapter = productAdapter
        recyclerViewProduct.layoutManager = LinearLayoutManager(this)
        recyclerViewProduct.setHasFixedSize(true)

         */

    }
}