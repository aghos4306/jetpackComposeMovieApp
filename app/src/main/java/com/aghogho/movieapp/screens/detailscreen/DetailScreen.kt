package com.aghogho.movieapp.screens.detailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.aghogho.movieapp.model.MovieData
import com.aghogho.movieapp.model.getMovies
import com.aghogho.movieapp.widgets.MovieRow

@Composable
fun DetailScreen(
    navController: NavController,
    movieData: String?
) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieData
    }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                elevation = 5.dp,
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack ,
                        contentDescription = "Back Arrow",
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                    Spacer(modifier = Modifier.width(250.dp))
                    Text(text = "Movies")
                }
            }
        }
    ) {
        Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                MovieRow(movie = newMovieList.first())
//                Text(
//                    //text = movieData.toString(),
//                    text = newMovieList[0].title,
//                    style = MaterialTheme.typography.h5
//                )

                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")

                HorizontalScrollableImageView(newMovieList)

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text(
                        text = "Go Back",
                    )
                }
            }
        }
    }
}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<MovieData>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Movie Poster Images"
                )
            }
        }
    }
}