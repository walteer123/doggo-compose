package com.walter.doggo_compose.breed.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class BreedRemote(
    private val id: Int,
    private val name: String
)