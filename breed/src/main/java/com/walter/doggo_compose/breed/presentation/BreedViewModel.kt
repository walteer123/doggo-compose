package com.walter.doggo_compose.breed.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walter.doggo_compose.breed.domain.BreedRepository
import com.walter.doggo_compose.breed.utils.updateState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BreedViewModel(private val repository: BreedRepository) : ViewModel() {

    val state: StateFlow<BreedState> get() = _state
    private val _state = MutableStateFlow(
        BreedState(
            items = listOf(),
            isLoading = true
        )
    )

    init {
        getBreeds()
    }

    private fun getBreeds() {
        viewModelScope.launch {
            repository.getBreeds().onSuccess { list ->
                _state.updateState {
                    it.copy(
                        items = list,
                        isLoading = false
                    )
                }
            }.onFailure {
                _state.updateState {
                    it.copy(isLoading = false)
                }
            }
        }
    }

}
