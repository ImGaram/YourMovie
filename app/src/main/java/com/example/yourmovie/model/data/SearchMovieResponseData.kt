package com.example.yourmovie.model.data

data class SearchMovieResponseData(
    val lastBuildDate: String,
    val total: Int,
    val start: Int,
    val display: Int,
    val movieItems: List<MovieItemData>
)
