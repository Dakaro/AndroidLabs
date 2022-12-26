package com.example.zakupy.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zakupy.model.ProductModel

object Shopcart {
    var shopList = arrayListOf<product> ()


    fun decreaseProduct(position: Int): Boolean{
        if(shopList[position].decreaseProduct() == false) {
            shopList.removeAt(position)
            return false
        }
        return true
    }

    fun increaseProduct(position: Int){
        shopList[position].increaseProduct()
    }

    fun addProduct(model: ProductModel) {
        for (prod in shopList) {
            if (prod.model == model) {
                prod.increaseProduct()
                return
            }
        }

        shopList.add(product(model))
    }

}

class product{
    var model: ProductModel? = null
    var count = 0

      fun increaseProduct(){
        count += 1
      }

    fun decreaseProduct(): Boolean{
        if( count == 1 ){
            count = 0
            return false
        }
        count -= 1
        return true
    }

    constructor(product: ProductModel){
        count = 1
        model = product
    }

}