package com.example.zakupy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.Required
import org.bson.types.ObjectId


open class ProductModel(
    @PrimaryKey
    @SerializedName("productId")
    var productId: Int,
    @Required
    @SerializedName("name")
    var name: String = "",
    @SerializedName("categoryId")
    var categoryId: CategoryModel? = null,
    @SerializedName("country")
    var country: String
): RealmObject(){
    public constructor(): this(1, "", null, "")
}