package com.example.dao

import com.example.models.*

interface DAOFacade {
    suspend fun allProducts(): List<Product>
    suspend fun product(id: Int): Product?
    suspend fun addNewProduct( name: String, category: Int, country: String): Product?
    suspend fun editProduct(id: Int, name: String, category: Int, country: String): Boolean
    suspend fun deleteProduct(id: Int): Boolean
    suspend fun allCategories(): List<Category>
    suspend fun category(id: Int): Category?
    suspend fun addNewCategory( name: String, type: Boolean, eco: Boolean): Category?
    suspend fun editCategory(id: Int, name: String, type: Boolean, eco: Boolean): Boolean
    suspend fun deleteCategory(id: Int): Boolean
}
