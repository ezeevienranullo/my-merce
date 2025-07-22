package com.example.mymerce.domain

import com.example.mymerce.data.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}

