package com.walter.doggo.network.di

import com.walter.doggo.network.httpclient.KtorHttpClientProvider
import com.walter.doggo.network.httpclient.KtorHttpClientProviderImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectNetworkModule() = loadNetworkModule

private val loadNetworkModule by lazy {
    loadKoinModules(
        listOf(
            providerModule
        )
    )
}

private val providerModule = module {
    single<KtorHttpClientProvider> { KtorHttpClientProviderImpl() }
}
