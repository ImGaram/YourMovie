package com.example.yourmovie.model.data

import com.example.yourmovie.model.data.popular.ResultData

data class PopularMovieResponseData(
    val page: Int,
    val results: List<ResultData>,
    val totalPages: Int,
    val totalResults: Int
)