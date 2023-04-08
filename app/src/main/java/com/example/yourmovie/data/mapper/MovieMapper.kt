package com.example.yourmovie.data.mapper

import com.example.yourmovie.data.model.MovieItem
import com.example.yourmovie.data.model.SearchMovieResponse
import com.example.yourmovie.model.data.MovieItemData
import com.example.yourmovie.model.data.SearchMovieResponseData

object MovieMapper {
    fun searchMovieToData(searchMovieResponse: SearchMovieResponse): SearchMovieResponseData {
        return SearchMovieResponseData(
            lastBuildDate = searchMovieResponse.lastBuildDate,
            total = searchMovieResponse.total,
            start = searchMovieResponse.start,
            display = searchMovieResponse.display,
            movieItems = searchMovieResponse.movieItems.map { movieItemToData(it) }
        )
    }

    private fun movieItemToData(movieItem: MovieItem): MovieItemData {
        return MovieItemData(
            title = movieItem.title,
            link = movieItem.link,
            image = movieItem.image,
            subtitle = movieItem.subtitle,
            pubDate = movieItem.pubDate,
            director = movieItem.director,
            actor = movieItem.actor,
            userRating = movieItem.userRating
        )
    }
}