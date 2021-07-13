package com.walter.doggo_compose.breed.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BreedViewModel : ViewModel() {

    val state: StateFlow<BreedState> get() = _state
    private val _state = MutableStateFlow(BreedState.Loading)

}
