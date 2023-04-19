package com.example.yourmovie.model.data

import com.example.yourmovie.model.data.search.MovieItemData

data class PopularMovieResponseData(
    val page: Int,
    val results: List<MovieItemData>,
    val totalPages: Int,
    val totalResults: Int
)