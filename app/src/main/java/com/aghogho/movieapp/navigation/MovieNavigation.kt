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

//Pass Information along when you navigate from HomeScreen to DetailScreen.
//We have the navGraph setup for DetailScreen. If we want to pass the title of movie in
//HomeScreen to DetailScreen, when the Card in HomeScreen is clicked, we pass an argument,
//and its type. To get the information
//How do we retrive the information from current route and pass it along to the next route when
//a click event happen ? We have access to NavBackStackEntry in the composable lambda. The inherent
//variable contains the information we want, we can pass that variable into DetailScreen. I named
//the variable here as backStackEntry.
//Fix too many argument for DetailScreen, by passing a var of type String as parameter, because
//DetailScreen will now be expecting a String parameter passed into it.
//Now go to DetailScreen and pass into the Text the data that should be captured, the data is now
//stored in movieData var.
//Now go to HomeScreen where and also pass in the data there because this is the screen we are
//navigating from to DetailScreen. In the MovieRow , within the lambda, define a var, call it
// passMovieContent. And concatenate this var to the route in the navController.navigate.
//This is basically passing the argument (passMovieContent) into the route.
//The idea is to be able to pass loads of info from an object. Imagine if the movie is an object
//from some API, we can pass the id of a specific object, once the id of movie clicked matches an
//id from the data source, get that particular movie and get as much key value pair you want from
//there and display in your application.

//Display the content that is passed along when navigating properly.
//In DatialScreen file, create a Surface, Create a Column within Surface. Put the Text into
// the Column and apply proper modifiers and styles.

//Create Back Button from DetailScreen.
//We want to be able to go back to the previous screen/composable which is HomeScreen. As we
//navigate we do have a stack. To go back we need to pop the Screen which is on top of the screen
//we navigating from. Within the onClick, put there navController.popBackStack.

//Add TopNavBar and back button when we navigate to DetailScreen.
//Notice that when we navigate to DetailScreen, we loose the TopNavBar. We want to add that and
//also a back btn