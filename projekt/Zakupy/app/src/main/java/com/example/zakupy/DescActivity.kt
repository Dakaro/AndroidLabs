package com.example.zakupy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.zakupy.model.ProductModel
import com.example.zakupy.model.providesRealmConfig
import com.example.zakupy.ui.dashboard.Shopcart
import com.example.zakupy.ui.dashboard.product
import io.realm.Realm
import io.realm.kotlin.where

class DescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desc_activity)

        var productDetails = findViewById<TextView>(R.id.productDetails)

        productDetails.text = intent.getStringExtra("descText")

        var backButton = findViewById<Button>(R.id.button2)

        backButton.setOnClickListener {
            onBackPressed()
        }

        var addButton = findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            var realm = Realm.getInstance(providesRealmConfig())
            var product: ProductModel? = realm.where<ProductModel>(ProductModel::class.java).contains("name", productDetails.text.toString()).findFirst()
            Shopcart.addProduct( product!! )
        }


    }
}