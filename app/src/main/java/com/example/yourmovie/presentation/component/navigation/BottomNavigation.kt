package com.example.yourmovie.presentation.component.navigation

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yourmovie.presentation.component.navigation.screen.Screen
import com.example.yourmovie.presentation.view.ui.theme.BtmSelectColor
import com.example.yourmovie.presentation.view.ui.theme.BtmUnSelectColor
import com.example.yourmovie.presentation.viewmodel.PopularMovieViewModel
import com.example.yourmovie.presentation.viewmodel.SearchMovieViewModel

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Movie: BottomNavItem(Screen.Movie.route, Icons.Filled.Home, "영화")
    object Search: BottomNavItem(Screen.Search.route, Icons.Filled.Search, "검색")
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationView(
    searchMovieViewModel: SearchMovieViewModel,
    popularMovieViewModel: PopularMovieViewModel
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.Black
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val items = listOf(
                    BottomNavItem.Movie,
                    BottomNavItem.Search
                )

                items.forEach { item ->
                    BottomNavigationItem(
                        icon = { Icon(item.icon, contentDescription = null) },
                        label = { Text(text = item.label) },
                        selected = currentRoute == item.route,
                        selectedContentColor = BtmSelectColor,
                        unselectedContentColor = BtmUnSelectColor,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        YourMovieNavItem(
            navController = navController,
            searchMovieViewModel = searchMovieViewModel,
            popularMovieViewModel = popularMovieViewModel
        )
    }
}