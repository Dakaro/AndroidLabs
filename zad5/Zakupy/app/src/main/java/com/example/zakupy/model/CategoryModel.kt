package com.example.zakupy.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CategoryModel (
    @PrimaryKey val categoryId: Int,
    val categoryName: String?,
    val country: String?
)
