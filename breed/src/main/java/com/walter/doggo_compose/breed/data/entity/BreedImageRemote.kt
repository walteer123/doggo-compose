package com.walter.doggo_compose.breed.data.entity

import com.walter.doggo_compose.breed.domain.entity.BreedImage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreedImageRemote(
    @SerialName("id") override val id: String,
    @SerialName("url") override val url: String
) : BreedImage
