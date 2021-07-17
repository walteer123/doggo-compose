package com.walter.doggo_compose.breed.presentation

import com.walter.doggo_compose.breed.domain.entity.Breed

data class BreedState(
    val items: List<Breed>,
    val isLoading: Boolean
)
