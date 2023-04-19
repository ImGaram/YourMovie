package com.example.yourmovie.data.mapper

import com.example.yourmovie.data.model.CastingResponse
import com.example.yourmovie.data.model.MovieDetailResponse
import com.example.yourmovie.data.model.PopularMovieResponse
import com.example.yourmovie.data.model.SearchMovieResponse
import com.example.yourmovie.data.model.casting.Cast
import com.example.yourmovie.data.model.detail.BelongsToCollection
import com.example.yourmovie.data.model.detail.Genre
import com.example.yourmovie.data.model.search.MovieItem
import com.example.yourmovie.model.data.CastingResponseData
import com.example.yourmovie.model.data.MovieDetailResponseData
import com.example.yourmovie.model.data.PopularMovieResponseData
import com.example.yourmovie.model.data.SearchMovieResponseData
import com.example.yourmovie.model.data.casting.CastData
import com.example.yourmovie.model.data.detail.BelongsToCollectionData
import com.example.yourmovie.model.data.detail.GenreData
import com.example.yourmovie.model.data.search.MovieItemData

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
            id = movieItem.id,
            originalLanguage = movieItem.originalLanguage,
            originalTitle = movieItem.originalTitle,
            overview = movieItem.overview,
            posterPath = movieItem.posterPath,
            releaseDate = movieItem.releaseDate,
            title = movieItem.title,
            video = movieItem.video,
            voteAverage = movieItem.voteAverage,
            voteCount = movieItem.voteCount
        )
    }

    fun movieDetailResponseToData(movieDetailResponse: MovieDetailResponse): MovieDetailResponseData {
        return MovieDetailResponseData(
            adult = movieDetailResponse.adult,
            backdropPath = movieDetailResponse.backdropPath,
            belongsToCollection = belongsToCollectionToData(movieDetailResponse.belongsToCollection),
            budget = movieDetailResponse.budget,
            genres = movieDetailResponse.genres.map { genreToData(it) },
            homepage = movieDetailResponse.homepage,
            id = movieDetailResponse.id,
            imdbId = movieDetailResponse.imdbId,
            originalLanguage = movieDetailResponse.originalLanguage,
            originalTitle = movieDetailResponse.originalTitle,
            overview = movieDetailResponse.overview,
            popularity = movieDetailResponse.popularity,
            posterPath = movieDetailResponse.posterPath,
            releaseDate = movieDetailResponse.releaseDate,
            revenue = movieDetailResponse.revenue,
            runtime = movieDetailResponse.runtime,
            status = movieDetailResponse.status,
            tagline = movieDetailResponse.tagline,
            title = movieDetailResponse.title,
            video = movieDetailResponse.video,
            voteAverage = movieDetailResponse.voteAverage,
            voteCount = movieDetailResponse.voteCount
        )
    }

    private fun belongsToCollectionToData(belongsToCollection: BelongsToCollection?): BelongsToCollectionData {
        return BelongsToCollectionData(
            backdropPath = belongsToCollection?.backdropPath,
            id = belongsToCollection?.id,
            name = belongsToCollection?.name,
            posterPath = belongsToCollection?.posterPath
        )
    }

    private fun genreToData(genre: Genre): GenreData {
        return GenreData(
            id = genre.id,
            name = genre.name
        )
    }

    fun castingResponseToData(castingResponse: CastingResponse): CastingResponseData {
        return CastingResponseData(
            cast = castingResponse.cast.map { castToData(it) },
            id = castingResponse.id
        )
    }

    private fun castToData(cast: Cast): CastData {
        return CastData(
            character = cast.character,
            gender = cast.gender,
            knownForDepartment = cast.knownForDepartment,
            order = cast.order,
            name = cast.name,
            originalName = cast.originalName,
            profilePath = cast.profilePath
        )
    }

    fun popularMovieResponseToData(popularMovieResponse: PopularMovieResponse): PopularMovieResponseData {
        return PopularMovieResponseData(
            page = popularMovieResponse.page,
            results = popularMovieResponse.results.map { movieItemToData(it) },
            totalPages = popularMovieResponse.totalPages,
            totalResults = popularMovieResponse.totalResults
        )
    }
}