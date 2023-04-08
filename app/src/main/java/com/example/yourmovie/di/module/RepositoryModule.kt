package com.example.yourmovie.di.module

import com.example.yourmovie.data.repository.SearchMovieRepositoryImpl
import com.example.yourmovie.model.repository.SearchMovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideSearchMovieRepository(
        searchMovieRepositoryImpl: SearchMovieRepositoryImpl
    ): SearchMovieRepository
}