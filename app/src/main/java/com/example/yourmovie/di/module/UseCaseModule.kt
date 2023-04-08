package com.example.yourmovie.di.module

import com.example.yourmovie.model.repository.SearchMovieRepository
import com.example.yourmovie.model.usecase.SearchMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideSearchMovieUseCase(searchMovieRepository: SearchMovieRepository) = SearchMovieUseCase(searchMovieRepository)
}