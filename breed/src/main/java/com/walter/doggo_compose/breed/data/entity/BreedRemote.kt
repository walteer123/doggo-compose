package com.walter.doggo_compose.breed.data.entity

import com.walter.doggo_compose.breed.domain.entity.Breed
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreedRemote(
    @SerialName("id") override val id: String,
    @SerialName("name") override val name: String
) : Breed
