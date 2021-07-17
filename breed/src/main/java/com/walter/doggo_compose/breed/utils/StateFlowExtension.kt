package com.walter.doggo_compose.breed.utils

import kotlinx.coroutines.flow.MutableStateFlow

fun <T> MutableStateFlow<T>.updateState(onUpdate: (T) -> T) {
    this.value.let {
        it?.let {
            this.value = onUpdate.invoke(it)
        }
    }
}