package com.example.yourmovie.presentation.view.detail

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.yourmovie.BuildConfig
import com.example.yourmovie.R
import com.example.yourmovie.model.data.CastingResponseData
import com.example.yourmovie.model.data.MovieDetailResponseData
import com.example.yourmovie.presentation.component.card.CastingProfileCard
import com.example.yourmovie.presentation.component.text.AutoSizeText
import com.example.yourmovie.presentation.viewmodel.CastingViewModel
import com.example.yourmovie.presentation.viewmodel.MovieDetailViewModel
import com.skydoves.landscapist.coil.CoilImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    private val movieDetailViewModel by viewModels<MovieDetailViewModel>()
    private val castingViewModel by viewModels<CastingViewModel>()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.getIntExtra("movieId", 0)
        setContent {
            setContent {
                DetailScreen(
                    movieId = data,
                    movieDetailViewModel = movieDetailViewModel,
                    castingViewModel = castingViewModel
                )
            }
        }
    }
}

@Composable
fun DetailScreen(
    movieId: Int?,
    movieDetailViewModel: MovieDetailViewModel,
    castingViewModel: CastingViewModel
) {
    val context = LocalContext.current as Activity
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        movieDetailViewModel.movieDetail(movieId!!, BuildConfig.API_KEY)
        castingViewModel.getCasting(movieId, BuildConfig.API_KEY)
        val movieDetailResult = movieDetailViewModel.movieDetail.collectAsState()
        val castingResult = castingViewModel.casting.collectAsState()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            CoilImage(
                imageModel = { "https://image.tmdb.org/t/p/w400${movieDetailResult.value?.backdropPath}" },
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

        MainMovieView(data = movieDetailResult.value)

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
            text = movieDetailResult.value?.overview.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp)
        )

        CastingView(data = castingResult.value)
    }
}

@Composable
fun MainMovieView(data: MovieDetailResponseData?) {
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

            var genresString = ""
            var listIndexCnt = 0
            data?.genres?.forEach {
                listIndexCnt++
                if (listIndexCnt == data.genres.size) genresString += it.name
                else genresString = genresString+it.name+", "
            }
            Text(
                text = "장르: $genresString",
                modifier = Modifier.padding(top = 5.dp)
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

@Composable
fun CastingView(data: CastingResponseData?) {
    Text(
        text = "출연자",
        modifier = Modifier.padding(start = 15.dp, bottom = 10.dp, top = 10.dp),
        style = TextStyle(
            fontSize = 19.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        if (data != null) {
            items(data.cast) { item ->
                CastingProfileCard(data = item)
            }
        }
    }
}