package com.example.zakupy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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


    }
}