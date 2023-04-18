package com.example.yourmovie.model.usecase

import com.example.yourmovie.model.data.CastingResponseData
import com.example.yourmovie.model.repository.CastingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CastingUseCase @Inject constructor(
    private val castingRepository: CastingRepository
) {
    suspend operator fun invoke(
        movieId: Int,
        apiKey: String
    ): Flow<CastingResponseData> {
        return castingRepository.getCasting(movieId, apiKey)
    }
}