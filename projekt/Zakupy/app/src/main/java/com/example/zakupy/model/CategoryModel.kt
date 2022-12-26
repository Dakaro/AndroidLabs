package com.example.zakupy.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.realm.RealmObject
import io.realm.annotations.Required
import org.bson.types.ObjectId
import javax.annotation.Nullable


open class CategoryModel  (
    @PrimaryKey
    var categoryId: Int? = null ,
    var categoryName: String?= null,
    var type: Boolean? = null , //AGD or RTV
    var eco: Boolean? = null
): RealmObject() {
   public constructor() : this (1, "", false, false)
}






