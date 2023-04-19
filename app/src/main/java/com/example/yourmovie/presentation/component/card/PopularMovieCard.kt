package com.example.yourmovie.presentation.component.card

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.yourmovie.model.data.search.MovieItemData
import com.example.yourmovie.presentation.view.detail.DetailActivity
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PopularMovieCard(movieItemData: MovieItemData) {
    val context = LocalContext.current

    Box {
        Card(
            modifier = Modifier
                .width(160.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(8.dp)),
            onClick = {
                context.startActivity(
                    Intent(context, DetailActivity::class.java)
                        .putExtra("movieId", movieItemData.id)
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CoilImage(
                    imageModel = {
                        if (movieItemData.posterPath == null) R.drawable.empty_movie
                        else "https://image.tmdb.org/t/p/w200${movieItemData.posterPath}"
                    },
                    modifier = Modifier
                        .wrapContentSize()
                        .size(width = 160.dp, height = 240.dp)
                )

                Text(
                    text = movieItemData.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp),
                    style = TextStyle(
                        fontSize = 17.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}