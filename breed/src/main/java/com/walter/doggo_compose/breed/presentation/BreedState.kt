package com.walter.doggo_compose.breed.presentation

import androidx.paging.PagingData
import com.walter.doggo_compose.breed.domain.entity.Breed

data class BreedState(
    val items: PagingData<Breed>,
    val isLoading: Boolean
)
