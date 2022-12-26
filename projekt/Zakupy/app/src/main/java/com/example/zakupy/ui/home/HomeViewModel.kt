package com.example.zakupy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zakupy.Control.DatabaseControl
import com.example.zakupy.model.ProductModel
import com.example.zakupy.model.providesRealmConfig
import io.realm.Realm
import io.realm.RealmResults

object Product{


    val realm = Realm.getInstance(providesRealmConfig())
    var productList: RealmResults<ProductModel> = realm.where(ProductModel::class.java).findAll()


}