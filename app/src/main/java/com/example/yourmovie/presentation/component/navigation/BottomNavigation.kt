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
import com.example.yourmovie.presentation.view.ui.theme.BtmSelectColor
import com.example.yourmovie.presentation.view.ui.theme.BtmUnSelectColor

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object BoxOffice: BottomNavItem("movie", Icons.Filled.Home, "영화")
    object Search: BottomNavItem("search", Icons.Filled.Search, "검색")
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationView() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.Black
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val items = listOf(
                    BottomNavItem.BoxOffice,
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
        YourMovieNavItem(navController = navController)
    }
}