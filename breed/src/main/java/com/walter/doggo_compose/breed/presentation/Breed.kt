package com.walter.doggo_compose.breed.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.walter.doggo_compose.breed.domain.entity.Breed
import org.koin.androidx.compose.getViewModel

@Composable
fun Breed() {
    val viewModel = getViewModel<BreedViewModel>()
    val state by viewModel.state.collectAsState()
    BreedContent(state.items)
}

@Composable
private fun BreedContent(breeds: List<Breed>) {
    Surface {
        LazyColumn {
            items(breeds) { breed ->
                BreedCard(breed)
            }
        }
    }
}

@Composable
private fun BreedCard(breed: Breed) {
    Column(modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
        Text(text = breed.name)
    }
}

@Preview
@Composable
fun PreviewBreedContent() {
    val item = object : Breed {
        override val id: String
            get() = "1"
        override val name: String
            get() = "Teste"
    }
    BreedContent(breeds = listOf(item, item))
}
