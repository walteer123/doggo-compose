package com.walter.doggo_compose.breed.domain

import com.walter.doggo_compose.breed.data.entity.BreedRemote

interface BreedRepository {
    suspend fun getBreeds(): Result<List<BreedRemote>>
}
