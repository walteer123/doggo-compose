package com.walter.doggo_compose.navigation.di

import com.walter.doggo_compose.navigation.domain.manager.NavigationManager
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectNavigationKoinModule() = loadKoinModule

private val loadKoinModule by lazy {
    loadKoinModules(
        listOf(
            managerModule
        )
    )
}

private val managerModule = module {
    single { NavigationManager() }
}