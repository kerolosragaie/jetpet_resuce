package hoods.com.jetpetrescue.features.details

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.jetpetrescue.core.data.DummyPetDataSource
import hoods.com.jetpetrescue.features.details.components.DetailsTopBar
import hoods.com.jetpetrescue.features.details.components.PetBasicInfoItem
import hoods.com.jetpetrescue.features.details.components.PetDetailsItem
import hoods.com.jetpetrescue.features.details.components.PetStoryItem

@Composable
fun DetailsScreen(
    index: Int,
    onClickArrowBack: () -> Unit,
) {
    val pet = DummyPetDataSource.dogList[index]

    Scaffold(
        topBar = {
            DetailsTopBar(
                onClickArrowBack = onClickArrowBack
            )
        },
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            item {
                PetBasicInfoItem(pet = pet)
            }
            item {
                PetStoryItem(description=pet.description)
            }
            item {
                PetDetailsItem(pet = pet)
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevDetailsScreen() {
    DetailsScreen(index = 0) {}
}