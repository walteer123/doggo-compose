package com.walter.doggo_compose.breed.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.getViewModel

@Composable
fun Breed() {
    val viewModel = getViewModel<BreedViewModel>()
    val state by viewModel.state.collectAsState()
    BreedContent(state)

}

@Composable
private fun BreedContent(state: BreedState) {
    Surface {
        Column {
            Text(text = "Hello from breeds!")
        }
    }
}

@Preview
@Composable
fun PreviewBreedContent() {
    BreedContent(state = BreedState.Loading)
}
