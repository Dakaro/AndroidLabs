package com.example.zakupy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.realm.RealmObject
import io.realm.annotations.Required
import org.bson.types.ObjectId


open class ProductModel(
    @PrimaryKey
    var productId: Int,
    @Required
    var name: String = "",
    var categoryId: CategoryModel? = null,
    var country: String
): RealmObject(){
    public constructor(): this(1, "", null, "")
}