package com.example.mymerce.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymerce.data.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.setValue
import com.example.mymerce.domain.ProductRepository


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: List<Product> get() = _products.value

    var isLoading by mutableStateOf(true)
        private set

    init {
        viewModelScope.launch {
            try {
                _products.value = repository.getProducts()
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Error: ${e.localizedMessage}")
            } finally {
                isLoading = false
            }
        }
    }
}


