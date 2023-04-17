package com.example.yourmovie.presentation.view.detail

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourmovie.R
import com.example.yourmovie.model.data.search.MovieItemData
import com.example.yourmovie.presentation.component.text.AutoSizeText
import com.skydoves.landscapist.coil.CoilImage

class DetailActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.getSerializableExtra("data", MovieItemData::class.java)
        setContent {
            setContent {
                DetailScreen(data = data)
            }
        }
    }
}

@Composable
fun DetailScreen(data: MovieItemData?) {
    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            CoilImage(
                imageModel = { "https://image.tmdb.org/t/p/w400${data?.backdropPath}" },
                modifier = Modifier.fillMaxSize()
            )

            Image(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "back arrow icon",
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        context.finish()
                    },
                colorFilter = ColorFilter.tint(color = Color.White)
            )
        }

        MainMovieView(data = data)

        Text(
            text = "줄거리",
            modifier = Modifier.padding(start = 15.dp, bottom = 10.dp),
            style = TextStyle(
                fontSize = 19.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        )
        Text(
            text = data?.overview.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
        )
    }
}

@Composable
fun MainMovieView(data: MovieItemData?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        CoilImage(
            imageModel = { "https://image.tmdb.org/t/p/w200${data?.posterPath}" },
            modifier = Modifier
                .wrapContentSize()
                .size(width = 120.dp, height = 180.dp)
                .padding(start = 10.dp)
                .clip(RoundedCornerShape(6.dp))
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 10.dp)
        ) {
            AutoSizeText(
                text = data?.title.toString(),
                color = Color.Black,
                targetTextSize = 22.sp,
                textStyle = TextStyle(
                    fontWeight = FontWeight.SemiBold
                )
            )
            AutoSizeText(
                text = data?.originalTitle.toString(),
                color = Color.Gray,
                targetTextSize = 15.sp,
                textStyle = TextStyle(
                    fontWeight = FontWeight.Normal
                )
            )
            Text(
                text = "${data?.originalLanguage}, ${data?.releaseDate}",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(top = 5.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.End),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star_icon),
                    contentDescription = "star icon",
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    modifier = Modifier
                        .padding(3.dp),
                    text = "${data?.voteAverage}/10(${data?.voteCount})"
                )
            }
        }
    }
}