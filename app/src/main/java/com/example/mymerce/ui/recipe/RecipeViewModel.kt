package com.example.mymerce.ui.recipe

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymerce.data.model.Product
import com.example.mymerce.data.model.Recipe
import com.example.mymerce.domain.GreetingRepository
import com.example.mymerce.domain.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private val repository: RecipeRepository
) : ViewModel() {
    private val _recipes = mutableStateOf<List<Recipe>>(emptyList())
    val recipes: List<Recipe> get() = _recipes.value

    var isLoading by mutableStateOf(true)
        private set

    init {
        viewModelScope.launch {
            try {
                _recipes.value = repository.getRecipes()
                Log.d("RecipeViewModel", "Results: ${_recipes.value}")
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Error: ${e.localizedMessage}")
            } finally {
                isLoading = false
            }
        }
    }

}

