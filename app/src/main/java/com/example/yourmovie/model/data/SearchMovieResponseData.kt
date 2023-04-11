package com.example.yourmovie.model.data

data class SearchMovieResponseData(
    val page: Int,
    val results: List<MovieItemData>,
    val totalPages: Int,
    val totalResults: Int
)
