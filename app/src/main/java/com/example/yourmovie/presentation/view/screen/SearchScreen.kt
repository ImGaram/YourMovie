package com.example.yourmovie.presentation.view.screen

import android.annotation.SuppressLint
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
import com.example.yourmovie.presentation.component.card.MovieCard
import com.example.yourmovie.presentation.component.search.MovieSearchView

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen() {
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
                    .padding(20.dp)
            ) {
                MovieSearchView(
                    value = textValue,
                    hint = "검색어를 입력하세요.",
                    onValueChange = {text -> textValue = text }
                )
            }

            val list = listOf(1,2,3,4,5,6,7,8)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                content = {
                    items(list) { item ->
                        MovieCard()
                    }
                },
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
        }
    }
}