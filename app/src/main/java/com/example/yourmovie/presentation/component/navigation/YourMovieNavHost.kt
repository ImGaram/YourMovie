package com.example.yourmovie.presentation.component.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yourmovie.model.data.MovieItemData
import com.example.yourmovie.presentation.component.navigation.screen.Screen
import com.example.yourmovie.presentation.view.screen.DetailScreen
import com.example.yourmovie.presentation.view.screen.MovieScreen
import com.example.yourmovie.presentation.view.screen.SearchScreen
import com.example.yourmovie.presentation.viewmodel.SearchMovieViewModel

@Composable
fun YourMovieNavItem(
    navController: NavHostController,
    searchMovieViewModel: SearchMovieViewModel
) {
    NavHost(navController = navController, startDestination = BottomNavItem.Movie.route) {
        composable(Screen.Movie.route) { MovieScreen() }
        composable(
            route = Screen.Search.route
        ) {
            SearchScreen(
                searchMovieViewModel = searchMovieViewModel,
                navController = navController
            )
        }
        composable(Screen.Detail.route) {
            val data = remember {
                navController.previousBackStackEntry?.savedStateHandle?.get<MovieItemData>("data")
            }
            DetailScreen(data)
        }
    }
}