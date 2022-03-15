package com.aghogho.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        "Suits"
    )
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {
        LazyColumn {
            items(items = movieList) { // for each item gotten from movieList, show the item with implicit var it
                MovieRow(movie = it)
            }
        }
    }
}
//use this fun to create a card for each movie. Loop through movie items and create a nice
//card around each movie title. Call this fun within LazyColumn of MainContent and pass Text
//as the string movie.
//Add more ui components or widgets later.
@Composable
fun MovieRow(movie: String) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            elevation = 6.dp
    ) {
        Text(text = movie)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}