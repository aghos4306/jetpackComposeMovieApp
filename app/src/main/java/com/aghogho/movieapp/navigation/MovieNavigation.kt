package com.aghogho.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        //www.moviedatabase.com/genre/id=3
        composable(MovieScreens.DetailScreen.name+"/{movie-data}",
            arguments = listOf(navArgument(name = "movie-data") {type = NavType.StringType})) { backStackEntry ->
            DetailScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie-data")
            )
        }
    }
}

