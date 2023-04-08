package com.example.yourmovie.di.module

import com.example.yourmovie.data.source.datasource.SearchMovieDataSource
import com.example.yourmovie.data.source.datasourceimpl.SearchMovieDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun provideSearchMovieDataSource(
        searchMovieDataSourceImpl: SearchMovieDataSourceImpl
    ): SearchMovieDataSource
}