package com.example.mymerce.data.model

data class Recipe(
    val name: String,
    val image: String,
    val cuisine: String,
    val difficulty: String,
    val rating: String,
    val servings: String,
    val ingredients: List<String>,
    val instructions: List<String>,
)

data class RecipeResponse(
    val recipes: List<Recipe>
)