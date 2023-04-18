package com.example.yourmovie.di.module

import com.example.yourmovie.data.source.datasource.*
import com.example.yourmovie.data.source.datasourceimpl.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindSearchMovieDataSource(
        searchMovieDataSourceImpl: SearchMovieDataSourceImpl
    ): SearchMovieDataSource

    @Binds
    abstract fun bindMovieDetailDataSource(
        movieDetailDataSourceImpl: MovieDetailDataSourceImpl
    ): MovieDetailDataSource

    @Binds
    abstract fun bindCastingDataSource(
        castingDataSourceImpl: CastingDataSourceImpl
    ): CastingDataSource

    @Binds
    abstract fun bindPopularMovieDataSource(
        popularMovieDataSourceImpl: PopularMovieDataSourceImpl
    ): PopularMovieDataSource
}