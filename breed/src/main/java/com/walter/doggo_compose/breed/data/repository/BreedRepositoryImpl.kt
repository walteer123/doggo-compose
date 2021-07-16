package com.walter.doggo_compose.breed.data.repository

import com.walter.doggo.network.httpclient.KtorHttpClientProvider
import com.walter.doggo_compose.breed.data.entity.BreedRemote
import com.walter.doggo_compose.breed.domain.BreedRepository
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BreedRepositoryImpl(private val client: KtorHttpClientProvider) : BreedRepository {

    override suspend fun getBreeds(): Result<List<BreedRemote>> = runCatching {
        withContext(Dispatchers.IO) {
            client.get().get(path = "breeds")
        }
    }


}
