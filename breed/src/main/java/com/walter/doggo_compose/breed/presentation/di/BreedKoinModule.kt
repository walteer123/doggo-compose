package com.walter.doggo_compose.breed.presentation.di

import com.walter.doggo_compose.breed.data.repository.BreedRepositoryImpl
import com.walter.doggo_compose.breed.domain.BreedRepository
import com.walter.doggo_compose.breed.presentation.BreedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectBreedKoinModule() = loadKoinModule

private val loadKoinModule by lazy {
    loadKoinModules(
        listOf(
            presentationModule,
            repositoryModule
        )
    )
}

private val presentationModule = module {
    viewModel { BreedViewModel(get()) }
}

private val repositoryModule = module {
    single<BreedRepository> { BreedRepositoryImpl(get()) }
}
