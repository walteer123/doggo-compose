package com.walter.doggo_compose.breed.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walter.doggo_compose.breed.domain.BreedRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BreedViewModel(private val repository: BreedRepository) : ViewModel() {

    val state: StateFlow<BreedState> get() = _state
    private val _state = MutableStateFlow(BreedState.Loading)

    fun getBreeds() {
        viewModelScope.launch {
            repository.getBreeds().onSuccess {
                val teste = it
                Log.d("ktor test", it.size.toString())
            }.onFailure {
                Log.d("ktor test", it.message ?: "teste")
            }
        }
    }

}
