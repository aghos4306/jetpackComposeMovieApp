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
import com.aghogho.movieapp.navigation.MovieScreens

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
                MovieRow(movie = it) { passMovieContent ->
                    //Log.d("TAG", "MainContent: $movie")
                    navController.navigate(route = MovieScreens.DetailScreen.name+"/$passMovieContent")
                }
            }
        }
    }
}

//I passed navController parameter in mainContent because I want to be able to use to click on
//something, a card in this case, and get navigated to somewhere, DetailScreen.
//Within the MovieRow, instead of just logging movie, use navController to navigate when the
//row is clicked. We need to append the variable to DetailScreen Route in MovieNavigation file.

