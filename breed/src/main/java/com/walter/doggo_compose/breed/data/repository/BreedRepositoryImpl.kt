package com.walter.doggo_compose.breed.data.repository

import com.walter.doggo.network.httpclient.KtorHttpClientProvider
import com.walter.doggo_compose.breed.data.entity.BreedRemote
import com.walter.doggo_compose.breed.domain.repository.BreedRepository
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BreedRepositoryImpl(private val client: KtorHttpClientProvider) : BreedRepository {

    override suspend fun getBreeds(page: Int) = runCatching {
        withContext(Dispatchers.IO) {
            client.instance().get<List<BreedRemote>>(path = "/v1/breeds") {
                parameter("attach_breed", 0)
                parameter("page", page)
                parameter("limit", 20)
            }
        }
    }

}
