package com.example.yourmovie.di.module

import com.example.yourmovie.data.repository.*
import com.example.yourmovie.model.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindSearchMovieRepository(
        searchMovieRepositoryImpl: SearchMovieRepositoryImpl
    ): SearchMovieRepository

    @Binds
    abstract fun bindMovieDetailRepository(
        movieDetailRepositoryImpl: MovieDetailRepositoryImpl
    ): MovieDetailRepository

    @Binds
    abstract fun bindCastingRepository(
        castingRepositoryImpl: CastingRepositoryImpl
    ): CastingRepository

    @Binds
    abstract fun bindPopularMovieRepository(
        popularMovieRepositoryImpl: PopularMovieRepositoryImpl
    ): PopularMovieRepository
}