package com.walter.doggo_compose.breed.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.walter.doggo_compose.breed.data.repository.BreedDataSource
import com.walter.doggo_compose.breed.domain.BreedRepository
import com.walter.doggo_compose.breed.utils.updateState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BreedViewModel(private val repository: BreedRepository) : ViewModel() {

    val state: StateFlow<BreedState> get() = _state
    private val _state = MutableStateFlow(
        BreedState(
            items = PagingData.empty(),
            isLoading = false
        )
    )

    val breeds = Pager(PagingConfig(pageSize = 20)) {
        BreedDataSource(repository)
    }.flow

    init {
        viewModelScope.launch {
            breeds.collect { data ->
                _state.updateState { it.copy(items = data) }
            }
        }
    }
}
