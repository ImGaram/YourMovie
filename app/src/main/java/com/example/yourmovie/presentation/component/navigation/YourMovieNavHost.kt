package com.example.yourmovie.presentation.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yourmovie.presentation.component.navigation.screen.Screen
import com.example.yourmovie.presentation.view.screen.MovieScreen
import com.example.yourmovie.presentation.view.screen.SearchScreen
import com.example.yourmovie.presentation.viewmodel.PopularMovieViewModel
import com.example.yourmovie.presentation.viewmodel.SearchMovieViewModel

@Composable
fun YourMovieNavItem(
    navController: NavHostController,
    searchMovieViewModel: SearchMovieViewModel,
    popularMovieViewModel: PopularMovieViewModel
) {
    NavHost(navController = navController, startDestination = BottomNavItem.Movie.route) {
        composable(Screen.Movie.route) {
            MovieScreen(popularMovieViewModel = popularMovieViewModel)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(searchMovieViewModel = searchMovieViewModel)
        }
    }
}