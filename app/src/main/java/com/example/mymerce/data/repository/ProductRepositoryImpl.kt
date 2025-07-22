package com.example.mymerce.data.repository

import com.example.mymerce.data.model.Product
import com.example.mymerce.data.remote.ApiCall
import com.example.mymerce.domain.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ApiCall
) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return api.getProducts().products
    }
}