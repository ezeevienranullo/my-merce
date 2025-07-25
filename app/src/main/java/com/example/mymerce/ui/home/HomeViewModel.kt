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
) : ViewModel() {

    val profileImageUrl = "https://cdn.nba.com/headshots/nba/latest/1040x760/1629029.png"
    var isLoading by mutableStateOf(true)
        private set

    init {
        viewModelScope.launch {
            isLoading = false
        }
    }
}


