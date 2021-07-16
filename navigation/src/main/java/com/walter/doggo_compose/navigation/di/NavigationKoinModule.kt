package com.walter.doggo_compose.navigation.di

import com.walter.doggo_compose.navigation.domain.manager.NavigationCollector
import com.walter.doggo_compose.navigation.domain.manager.NavigationManager
import com.walter.doggo_compose.navigation.domain.manager.NavigationManagerImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.binds
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
    single { NavigationManagerImpl() } binds arrayOf(
        NavigationManager::class,
        NavigationCollector::class
    )
}