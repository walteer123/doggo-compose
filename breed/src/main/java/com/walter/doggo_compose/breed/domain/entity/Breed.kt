package com.walter.doggo_compose.breed.domain.entity

interface Breed {
    val id: String
    val name: String
    val temperament: String
    val image: BreedImage
}
