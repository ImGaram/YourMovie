package com.example.yourmovie.di.module

import com.example.yourmovie.model.repository.CastingRepository
import com.example.yourmovie.model.repository.MovieDetailRepository
import com.example.yourmovie.model.repository.SearchMovieRepository
import com.example.yourmovie.model.usecase.CastingUseCase
import com.example.yourmovie.model.usecase.MovieDetailUseCase
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

    @Provides
    @Singleton
    fun provideMovieDetailUseCase(movieDetailRepository: MovieDetailRepository) = MovieDetailUseCase(movieDetailRepository)

    @Provides
    @Singleton
    fun provideCastingUseCase(castingRepository: CastingRepository) = CastingUseCase(castingRepository)
}