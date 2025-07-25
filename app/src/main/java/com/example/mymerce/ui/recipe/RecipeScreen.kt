package com.example.mymerce.ui.recipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.mymerce.data.model.Recipe

@Composable
fun RecipeScreen(viewModel : RecipeViewModel = hiltViewModel()) {
    val recipes = viewModel.recipes
    val loading = viewModel.isLoading

    if (loading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        RecipeGrid(recipes = recipes)
    }
}


@Composable
fun RecipeGrid(recipes: List<Recipe>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(recipes) { recipe ->
            ProductCard(recipe = recipe)
        }
    }
}

@Composable
fun ProductCard(recipe: Recipe) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = recipe.image,
                contentDescription = recipe.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(recipe.cuisine, style = MaterialTheme.typography.h6)
            Text(
                recipe.rating,
                maxLines = 2,
                style = MaterialTheme.typography.body2
            )
            Text(
                "₱${recipe.servings}",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.primary
            )
        }
    }
}

