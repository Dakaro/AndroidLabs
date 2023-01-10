package com.example.zakupy.Control

import com.example.zakupy.model.ProductModel
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiInterface {
    @GET("/")
    suspend fun getAllProducts(): ResponseBody
}