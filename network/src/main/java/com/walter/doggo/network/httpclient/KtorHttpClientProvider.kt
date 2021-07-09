package com.walter.doggo.network.httpclient

import io.ktor.client.HttpClient

interface KtorHttpClientProvider {
    fun get(): HttpClient
}
