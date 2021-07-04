package com.walter.doggo_compose.network.httpclient

import io.ktor.client.HttpClient

interface KtorHttpClientProvider {
    fun get(): HttpClient
}
