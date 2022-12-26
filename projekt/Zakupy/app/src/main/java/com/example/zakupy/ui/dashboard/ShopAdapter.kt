package com.example.zakupy.ui.dashboard

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zakupy.DescActivity
import com.example.zakupy.R
import com.example.zakupy.ui.home.Product
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShopAdapter: RecyclerView.Adapter<ShopViewHolder>() {
    lateinit var myContext: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        myContext = parent.context
        val layoutInflator = LayoutInflater.from(parent.context)
        val shopRow = layoutInflator.inflate(R.layout.shop_row, parent, false)
        return ShopViewHolder(shopRow)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val productId = holder.view.findViewById<TextView>(R.id.productId)
        val upButton = holder.view.findViewById<FloatingActionButton>(R.id.buttonUp)
        val downButton = holder.view.findViewById<FloatingActionButton>(R.id.buttonDown)
        val counter = holder.view.findViewById<TextView>(R.id.counter)


        productId.text =  Shopcart.shopList[position].model?.name
        counter.text = Shopcart.shopList[position].count.toString()

        upButton.setOnClickListener {
            Shopcart.shopList[position].increaseProduct()
            counter.text = Shopcart.shopList[position].count.toString()
        }

        downButton.setOnClickListener {
            if ( Shopcart.shopList[position].decreaseProduct() == false){
                downButton.isEnabled = false
                upButton.isEnabled = false
                notifyItemRemoved(position)
            }
            counter.text = Shopcart.shopList[position].count.toString()
        }

    }

    override fun getItemCount(): Int {
        return Shopcart.shopList.size
    }
}


class ShopViewHolder(val view: View): RecyclerView.ViewHolder(view)