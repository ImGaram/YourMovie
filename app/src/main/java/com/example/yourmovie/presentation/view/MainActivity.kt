package com.example.yourmovie.presentation.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.yourmovie.presentation.component.BottomNavigationView
import com.example.yourmovie.presentation.view.ui.theme.YourMovieTheme
import com.example.yourmovie.presentation.viewmodel.SearchMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val searchMovieViewModel by viewModels<SearchMovieViewModel>()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    BottomNavigationView()
                }
            ) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YourMovieTheme {
        BottomNavigationView()
    }
}