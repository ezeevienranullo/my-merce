package com.example.mymerce.data.remote

import com.example.mymerce.data.model.ProductResponse
import retrofit2.http.GET

interface ApiCall {
    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("recipes")
    suspend fun getRecipes(): ProductResponse
}
