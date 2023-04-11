package com.example.yourmovie.presentation.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yourmovie.presentation.view.screen.MovieScreen
import com.example.yourmovie.presentation.view.screen.SearchScreen
import com.example.yourmovie.presentation.viewmodel.SearchMovieViewModel

@Composable
fun YourMovieNavItem(
    navController: NavHostController,
    searchMovieViewModel: SearchMovieViewModel
) {
    NavHost(navController = navController, startDestination = BottomNavItem.BoxOffice.route) {
        composable(BottomNavItem.BoxOffice.route) { MovieScreen() }
        composable(BottomNavItem.Search.route) { SearchScreen(searchMovieViewModel) }
    }
}