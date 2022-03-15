package com.aghogho.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
                Text(text = it)
            }
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