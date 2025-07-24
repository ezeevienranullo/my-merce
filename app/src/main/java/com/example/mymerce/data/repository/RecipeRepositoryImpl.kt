package com.example.mymerce.data.repository

import com.example.mymerce.data.model.Recipe
import com.example.mymerce.data.remote.ApiCall
import com.example.mymerce.domain.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: ApiCall
) : RecipeRepository {
    override suspend fun getRecipes(): List<Recipe> {
        return api.getRecipes().recipes
    }
}