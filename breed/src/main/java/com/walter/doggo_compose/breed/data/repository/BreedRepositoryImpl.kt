package com.walter.doggo_compose.breed.data.repository

import com.walter.doggo.network.httpclient.KtorHttpClientProvider
import com.walter.doggo_compose.breed.data.entity.BreedRemote
import com.walter.doggo_compose.breed.domain.BreedRepository
import com.walter.doggo_compose.breed.domain.entity.Breed
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BreedRepositoryImpl(private val client: KtorHttpClientProvider) : BreedRepository {

    override suspend fun getBreeds(): Result<List<Breed>> = runCatching {
        withContext(Dispatchers.IO) {
            client.instance().get<List<BreedRemote>>(path = "/v1/breeds") {
                parameter("attach_breed", 0)
                parameter("page", 0)
                parameter("limit", 20)
            }
        }
    }

}
