package com.example.yourmovie.presentation.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourmovie.BuildConfig
import com.example.yourmovie.model.data.PopularMovieResponseData
import com.example.yourmovie.presentation.component.card.MovieCard
import com.example.yourmovie.presentation.component.card.PopularMovieCard
import com.example.yourmovie.presentation.viewmodel.PopularMovieViewModel

@Composable
fun MovieScreen(popularMovieViewModel: PopularMovieViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        popularMovieViewModel.getPopularMovie(BuildConfig.API_KEY)
        val popularMovieResult = popularMovieViewModel.popularMovie.collectAsState()

        Text(
            text = "인기 영화",
            modifier = Modifier.padding(start = 15.dp, top = 10.dp),
            style = TextStyle(
                fontSize = 19.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        )

        PopularMovieList(response = popularMovieResult)
    }
}

@Composable
fun PopularMovieList(
    response: State<PopularMovieResponseData?>
) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        if (response.value != null) {
            items(response.value!!.results) { item ->
                PopularMovieCard(movieItemData = item)
            }
        }
    }
}