package com.example.yourmovie.presentation.component.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.yourmovie.BuildConfig
import com.example.yourmovie.presentation.viewmodel.SearchMovieViewModel

@Composable
fun MovieSearchView(
    value: String,
    hint: String,
    maxLines: Int = 1,
    searchMovieViewModel: SearchMovieViewModel,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF363636))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            maxLines = maxLines,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            singleLine = true,
            textStyle = TextStyle(color = Color.White),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    if (value.isEmpty())
                        Text(
                            text = hint,
                            color = Color(0xFF616161)
                        )
                    innerTextField()
                }
            }
        )
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "search icon",
            modifier = Modifier
                .padding(5.dp)
                .size(24.dp)
                .clickable {
                    searchMovieViewModel.searchMovie(
                        apiKey = BuildConfig.API_KEY,
                        query = value
                    )
                },
            tint = Color.White
        )
    }
}