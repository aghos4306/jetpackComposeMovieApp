package com.aghogho.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aghogho.movieapp.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Magenta,
                elevation = 5.dp,
            ) {
                Text(text = "Movies")
            }
        },
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Gladiator",
        "Spartacus",
        "Borne Supremacy",
        "Die Another",
        "Die Hard",
        "Suits",
        "Lady in Red",
        "Dracula",
        "Mr and Mrs Smith"
    )
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {
        LazyColumn {
            items(items = movieList) { // for each item gotten from movieList, show the item with implicit var it
                MovieRow(movie = it) { movie ->
                    Log.d("TAG", "MainContent: $movie")

                }
            }
        }
    }
}