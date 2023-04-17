package com.example.yourmovie.model.data

import com.example.yourmovie.model.data.detail.BelongsToCollectionData
import com.example.yourmovie.model.data.detail.GenreData

data class MovieDetailResponseData(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: BelongsToCollectionData,
    val budget: Int,
    val genres: List<GenreData>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)