package com.example.zakupy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ProductModel (
    @PrimaryKey val productId: Int,
    val productName: String?,
    val categoryId: Int?
    )

