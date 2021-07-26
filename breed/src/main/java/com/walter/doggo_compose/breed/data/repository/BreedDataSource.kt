package com.walter.doggo_compose.breed.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.walter.doggo_compose.breed.domain.BreedRepository
import com.walter.doggo_compose.breed.domain.entity.Breed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BreedDataSource(private val repository: BreedRepository): PagingSource<Int, Breed>() {
    override fun getRefreshKey(state: PagingState<Int, Breed>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Breed> = withContext(Dispatchers.IO) {
        try {
            val nextPage = params.key ?: 0
            val response = repository.getBreeds(nextPage)
            val breedsList = response.getOrThrow()
            LoadResult.Page(
                data = breedsList,
                prevKey = if (nextPage == 0) null else nextPage - 1,
                nextKey = (params.key ?: 0) + 1
            )
        } catch (exception : Exception){
            LoadResult.Error(exception)
        }
    }

}