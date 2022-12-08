package com.example.zakupy.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

object Shopcart {
    var shopList = arrayListOf<product >(
        product("cosTam")
    )

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

    fun addProduct(name: String) {
        for (prod in shopList) {
            if (prod.name == name) {
                prod.increaseProduct()
                return
            }
        }

        shopList.add(product(name))
    }

}

class product{
    var count = 0
    var name = ""

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

    constructor(name: String){
        this.name = name
        count = 1
    }

}