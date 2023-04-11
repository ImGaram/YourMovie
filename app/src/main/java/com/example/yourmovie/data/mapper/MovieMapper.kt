package com.example.yourmovie.data.mapper

import com.example.yourmovie.data.model.MovieItem
import com.example.yourmovie.data.model.SearchMovieResponse
import com.example.yourmovie.model.data.MovieItemData
import com.example.yourmovie.model.data.SearchMovieResponseData

object MovieMapper {
    fun searchMovieToData(searchMovieResponse: SearchMovieResponse): SearchMovieResponseData {
        return SearchMovieResponseData(
            page = searchMovieResponse.page,
            results = searchMovieResponse.results.map { movieItemToData(it) },
            totalPages = searchMovieResponse.totalPages,
            totalResults = searchMovieResponse.totalResults
        )
    }

    private fun movieItemToData(movieItem: MovieItem): MovieItemData {
        return MovieItemData(
            adult = movieItem.adult,
            backdropPath = movieItem.backdropPath,
            genreIds = movieItem.genreIds,
            id = movieItem.id,
            originalLanguage = movieItem.originalLanguage,
            originalTitle = movieItem.originalTitle,
            overview = movieItem.overview,
            posterPath = movieItem.posterPath,
            popularity = movieItem.popularity,
            releaseDate = movieItem.releaseDate,
            title = movieItem.title,
            video = movieItem.video,
            voteAverage = movieItem.voteAverage,
            voteCount = movieItem.voteCount
        )
    }
}