package com.example.zakupy.Control

import com.example.zakupy.model.CategoryModel
import com.example.zakupy.model.ProductModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers
import java.lang.reflect.Constructor

class DatabaseControl constructor(private val config: RealmConfiguration) {

    suspend fun insertProduct(name: String, category: CategoryModel?, country: String) {
        val realm = Realm.getInstance(config)

        val currentIdNum: Number? = realm.where(ProductModel::class.java).max("productId")
        val nextId: Int
        nextId = if (currentIdNum == null) {
            1
        } else {
            currentIdNum.toInt() + 1
        }

        realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->

            val product = ProductModel(
                productId = nextId,
                name = name,
                categoryId = category,
                country = country
            )
            realmTransaction.insert(product)
        }
    }
}