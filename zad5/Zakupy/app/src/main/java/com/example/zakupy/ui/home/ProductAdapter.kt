package com.example.zakupy.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivity
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.RecyclerView
import com.example.zakupy.DescActivity
import com.example.zakupy.R
import kotlin.coroutines.coroutineContext


class ProductAdapter: RecyclerView.Adapter<ProductViewHolder>() {
    lateinit var myContext: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        myContext = parent.context
        val layoutInflator = LayoutInflater.from(parent.context)
        val productRow = layoutInflator.inflate(R.layout.product_row, parent, false)
        return ProductViewHolder(productRow)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productId = holder.view.findViewById<TextView>(R.id.productName)
        val infoButton = holder.view.findViewById<Button>(R.id.button)

        productId.text =  Product.productList[position].first
        infoButton.setOnClickListener {
            var newActivity: Intent = Intent(myContext, DescActivity::class.java)
            newActivity.putExtra("descText", Product.productList[position].second  )
            myContext.startActivity(newActivity)
        }

    }

    override fun getItemCount(): Int {
        return Product.productList.size
    }
}


class ProductViewHolder(val view: View): RecyclerView.ViewHolder(view)