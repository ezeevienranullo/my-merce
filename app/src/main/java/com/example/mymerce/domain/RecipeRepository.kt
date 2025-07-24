package com.example.mymerce.domain

import com.example.mymerce.data.model.Recipe

interface RecipeRepository {
    suspend fun getRecipes(): List<Recipe>
}

