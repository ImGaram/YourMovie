package com.example.yourmovie.presentation.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp)
            ) {
                MovieSearchView(value = textValue, hint = "검색어를 입력하세요.", onValueChange = {text -> textValue = text })
            }
        }
    }
}