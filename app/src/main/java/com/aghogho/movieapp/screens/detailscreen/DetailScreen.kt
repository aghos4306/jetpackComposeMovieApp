package com.aghogho.movieapp.screens.detailscreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(
    navController: NavController,
    movieData: String?
) {
    Text(
        text = movieData.toString()
    )
}