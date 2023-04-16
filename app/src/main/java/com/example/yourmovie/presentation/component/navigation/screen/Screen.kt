package com.example.yourmovie.presentation.component.navigation.screen

sealed class Screen(val route: String) {
    object Movie: Screen("movie")
    object Search: Screen("search")
    object Detail: Screen("detail")
}