package com.example.yourmovie.di.module

import com.example.yourmovie.data.repository.CastingRepositoryImpl
import com.example.yourmovie.data.repository.MovieDetailRepositoryImpl
import com.example.yourmovie.data.repository.SearchMovieRepositoryImpl
import com.example.yourmovie.model.repository.CastingRepository
import com.example.yourmovie.model.repository.MovieDetailRepository
import com.example.yourmovie.model.repository.SearchMovieRepository
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
}