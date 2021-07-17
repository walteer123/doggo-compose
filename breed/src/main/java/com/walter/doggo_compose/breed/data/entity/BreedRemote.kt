package com.walter.doggo_compose.breed.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreedRemote(
    @SerialName("id") private val id: String,
    @SerialName("name") private val name: String
)
