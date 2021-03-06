package com.walter.doggo_compose.breed.domain.repository

import com.walter.doggo_compose.breed.domain.entity.Breed

interface BreedRepository {
    suspend fun getBreeds(page: Int): Result<List<Breed>>
}
