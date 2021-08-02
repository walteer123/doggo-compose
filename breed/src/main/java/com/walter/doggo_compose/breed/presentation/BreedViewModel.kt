package com.walter.doggo_compose.breed.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.walter.doggo_compose.breed.data.repository.BreedDataSource
import com.walter.doggo_compose.breed.domain.repository.BreedRepository

class BreedViewModel(private val repository: BreedRepository) : ViewModel() {

    val breeds = Pager(PagingConfig(pageSize = 30)) {
        BreedDataSource(repository)
    }.flow

}
