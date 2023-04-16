package com.example.yourmovie.presentation.component.card

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourmovie.R
import com.example.yourmovie.model.data.MovieItemData
import com.example.yourmovie.presentation.view.detail.DetailActivity
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieCard(movieItemData: MovieItemData) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp)),
    ) {
        Card(
            onClick = {
                context.startActivity(
                    Intent(context, DetailActivity::class.java)
                        .putExtra("data", movieItemData)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CoilImage(
                    imageModel = {
                        if (movieItemData.posterPath == null) R.drawable.empty_movie
                        else "https://image.tmdb.org/t/p/w200${movieItemData.posterPath}"
                    },
                    modifier = Modifier
                        .wrapContentSize()
                        .size(width = 200.dp, height = 300.dp)
                )

                Text(
                    text = movieItemData.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp),
                    style = TextStyle(
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}