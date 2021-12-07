package com.example.movieinfo.presentation.home_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.movieinfo.domain.model.MovieSearchByTitle

@Composable
fun MovieDetails(
    movieSearchByTitle: MovieSearchByTitle,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
//        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Title: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.title) }
        })
        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Director: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.director) }
        })

        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Actors: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.actors) }
        })

        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Year: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.year) }
        })
        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Type: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.type) }
        })

        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Language: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.language) }
        })

        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("IMDB Rating: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.imdbRating) }
        })
        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Plot: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.title) }
        })
        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Awards: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.awards) }
        })

        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Box Office: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.boxOffice) }
        })
        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Genre: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.genre) }
        })


        Spacer(modifier = Modifier.padding(8.dp))
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append("Plot: ") }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontSize = MaterialTheme.typography.body1.fontSize
                )
            ) { append(movieSearchByTitle.plot) }
        })


    }
}