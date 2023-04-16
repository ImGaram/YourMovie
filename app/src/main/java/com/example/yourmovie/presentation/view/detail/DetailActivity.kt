package com.example.yourmovie.presentation.view.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourmovie.model.data.MovieItemData
import com.example.yourmovie.presentation.component.text.AutoSizeText
import com.skydoves.landscapist.coil.CoilImage

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.getSerializableExtra("data") as MovieItemData
        setContent {
            setContent {
                DetailScreen(data = data)
            }
        }
    }
}

@Composable
fun DetailScreen(
    data: MovieItemData?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            IconButton(
                modifier = Modifier.padding(15.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "back arrow icon",
                    tint = Color.Black
                )
            }

            CoilImage(
                imageModel = { "https://image.tmdb.org/t/p/w400${data?.backdropPath}" },
                modifier = Modifier.fillMaxSize()
            )
        }

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
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, top = 15.dp)
            ) {
                AutoSizeText(
                    text = data?.title.toString(),
                    color = Color.Black,
                    targetTextSize = 20.sp,
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
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
    }
}