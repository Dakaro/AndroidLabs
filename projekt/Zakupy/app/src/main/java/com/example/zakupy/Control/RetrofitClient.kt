package com.example.zakupy.Control

import com.example.zakupy.model.ProductModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

object RetrofitClient {

    fun getInstance(): Retrofit {

        var httpClient = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .callTimeout(10, TimeUnit.SECONDS)

        var retrofit: Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl("https://7d11-194-26-201-128.eu.ngrok.io")
            //.addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        return retrofit
    }

}