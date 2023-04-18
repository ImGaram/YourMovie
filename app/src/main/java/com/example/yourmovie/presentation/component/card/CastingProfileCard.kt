package com.example.yourmovie.presentation.component.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourmovie.model.data.casting.CastData
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CastingProfileCard(
    data: CastData
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .padding(15.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .width(200.dp)
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                CoilImage(
                    imageModel = { "https://image.tmdb.org/t/p/w200${data.profilePath}" }
                )
                Text(
                    text = data.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp),
                    style = TextStyle(
                        fontSize = 19.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = data.character,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light
                    ),
                    textAlign = TextAlign.Start,
                )
            }
        }
    }
}