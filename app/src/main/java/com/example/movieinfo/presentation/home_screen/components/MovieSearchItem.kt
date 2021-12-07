package com.example.movieinfo.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
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
import coil.compose.rememberImagePainter
import com.example.movieinfo.domain.model.MovieSearchByName

@Composable
fun MovieSearchItem(item: MovieSearchByName, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(item.poster),
                contentDescription = null,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(end = 4.dp)
            )
            Column(modifier = Modifier.fillMaxWidth().height(200.dp), verticalArrangement = Arrangement.SpaceEvenly) {
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
                    ) { append(item.title) }
                })
                Spacer(modifier = Modifier.padding(top = 4.dp, bottom = 4.dp))
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
                    ) { append(item.year) }
                })
                Spacer(modifier = Modifier.padding(4.dp))
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
                    ) { append(item.type) }
                })
//Spacer(modifier = Modifier.padding(4.dp))
            }
        }
    }
}