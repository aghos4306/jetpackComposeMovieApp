package com.aghogho.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aghogho.movieapp.ui.theme.MovieappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) { //container fun
    MovieappTheme {
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
            content()
        }
    }
}

@Composable
fun MainContent(
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

@Composable
fun MovieRow(movie: String, onItemClicked: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClicked(movie)
            },
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                    shape = RectangleShape,
                    elevation = 4.dp
            ) {
               Icon(
                   imageVector = Icons.Default.AccountBox,
                   contentDescription = "Movie Image"
               )
            }
            Text(text = movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}

//MovieRow fun: use this fun to create a card for each movie. Loop through movie items and create a nice
//card around each movie title. Call this fun within LazyColumn of MainContent and pass Text
//as the string movie.
//Add more ui components or widgets later.

//Make the Card Clickable. Add clickable to the card's modifier. Within the MovieRow, add
//a callback fun called onItemClicked as a paramter, it takes a String and returns Unit (nothing)
//call the onItemClicked callback fun within clickable in modifier and pass in the parameter movie.
//This parameter movie is what we can take and use to execute whatever we want when the Card is clicked.
//Within MovieRow called in MovieContent, execute what you want to do when the card is clicked.
//We can for example pass this into a different composable that could do something

//Navigation: Nav component has 3 major parts, navController, navHost and navGraph. Nav
//controller instructs navigation to occur navigate.navigate(route)
//navHost hosts each navigation graph item. It swaps out each destination (composable) when
//users navigate to a new screen.
//navGraph holds information about destination/screen/composable. NavGraph could have e.g
//SplashScreen, HomeScreen, DetailScreen and controls movement from compose to compose.