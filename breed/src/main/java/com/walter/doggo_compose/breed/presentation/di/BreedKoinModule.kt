package com.walter.doggo_compose.breed.presentation.di

import com.walter.doggo_compose.breed.presentation.BreedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectBreedKoinModule() = loadKoinModule

private val loadKoinModule by lazy {
    loadKoinModules(
        listOf(
            presentationModule
        )
    )
}

private val presentationModule = module {
    viewModel { BreedViewModel() }
}
