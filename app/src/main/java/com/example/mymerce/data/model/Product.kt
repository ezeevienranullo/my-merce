package com.example.mymerce.data.model

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val thumbnail: String
)

data class ProductResponse(
    val products: List<Product>
)