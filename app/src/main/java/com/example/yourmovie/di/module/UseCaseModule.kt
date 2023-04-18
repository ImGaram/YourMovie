package com.example.yourmovie.di.module

import com.example.yourmovie.model.repository.*
import com.example.yourmovie.model.usecase.*
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

    @Provides
    @Singleton
    fun providePopularMovieUseCase(popularMovieRepository: PopularMovieRepository) = PopularMovieUseCase(popularMovieRepository)
}