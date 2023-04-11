package com.example.yourmovie.presentation.view.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.yourmovie.BuildConfig
import com.example.yourmovie.presentation.component.card.MovieCard
import com.example.yourmovie.presentation.component.search.MovieSearchView
import com.example.yourmovie.presentation.viewmodel.SearchMovieViewModel
import kotlinx.coroutines.flow.collect

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    searchMovieViewModel: SearchMovieViewModel
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            var textValue by remember { mutableStateOf("") }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            ) {
                MovieSearchView(
                    value = textValue,
                    hint = "검색어를 입력하세요.",
                    searchMovieViewModel = searchMovieViewModel,
                    onValueChange = { text -> textValue = text }
                )
            }

            AnimatedVisibility(visible = !searchMovieViewModel.isLoading.value!!) {
                val result = searchMovieViewModel.searchMovie.collectAsState()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    content = {
                        if (result.value != null) {
                            items(result.value!!.results) { item ->
                                MovieCard(movieItemData = item)
                            }
                        }
                    }
                )
            }
        }
    }
}