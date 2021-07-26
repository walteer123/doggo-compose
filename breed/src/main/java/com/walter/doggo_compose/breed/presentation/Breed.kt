package com.walter.doggo_compose.breed.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.walter.doggo_compose.breed.domain.entity.Breed
import com.walter.doggo_compose.breed.domain.entity.BreedImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.koin.androidx.compose.getViewModel

@Composable
fun Breed(viewModel: BreedViewModel = getViewModel()) {
    val state by viewModel.state.collectAsState()
    BreedContent(viewModel.breeds)
}

@Composable
private fun BreedContent(breeds: Flow<PagingData<Breed>>) {
    val lazyBreedItems = breeds.collectAsLazyPagingItems()
    Surface {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(lazyBreedItems) { breed ->
                breed?.let { breedNotNull ->
                    BreedCard(breedNotNull)
                }
            }
        }
    }
}

@Composable
private fun BreedCard(breed: Breed) {
    Row() {
        Image(
            painter = rememberImagePainter(
                data = breed.image.url,
                builder = { transformations(CircleCropTransformation()) }
            ),
            contentDescription = "Dog image url",
            modifier = Modifier
                .size(80.dp)
                .padding(vertical = 8.dp),

            )
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = breed.name,
                fontSize = 16.sp,
                style = TextStyle(Color(0xff7986cb))
            )
            Text(
                text = breed.temperament,
                fontSize = 12.sp,
                style = TextStyle(Color(0xff49599a))
            )
        }
    }
}

@Preview
@Composable
fun PreviewBreedContent() {
    val item = mockedBreed()
    BreedContent(breeds = flowOf())
}

private fun mockedBreed() = object : Breed {
    override val id: String
        get() = "1"
    override val name: String
        get() = "Teste"
    override val temperament: String
        get() = "brabo"
    override val image: BreedImage
        get() = object : BreedImage {
            override val id: String
                get() = "1"
            override val url: String
                get() = "teste"
        }
}
