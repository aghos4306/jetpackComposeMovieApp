package com.aghogho.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aghogho.movieapp.screens.detailscreen.DetailScreen
import com.aghogho.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, 
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            //pass composable where this route should lead to. 
            HomeScreen(navController = navController)
        }
        composable(MovieScreens.DetailScreen.name) {
            DetailScreen(navController = navController)
        }
    }
}