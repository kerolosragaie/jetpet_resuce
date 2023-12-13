package hoods.com.jetpetrescue.features.home.presentation.screens.details

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.core.data.DummyPetDataSource
import hoods.com.jetpetrescue.features.home.domain.models.Animal
import hoods.com.jetpetrescue.features.home.presentation.screens.details.components.DetailsTopBar
import hoods.com.jetpetrescue.features.home.presentation.screens.details.components.OwnerInfoCard
import hoods.com.jetpetrescue.features.home.presentation.screens.details.components.PetBasicInfoItem
import hoods.com.jetpetrescue.features.home.presentation.screens.details.components.PetInfoCard
import hoods.com.jetpetrescue.features.home.presentation.screens.details.components.PetStoryItem

@Composable
fun DetailsScreen(
    animal: Animal,
    onClickArrowBack: () -> Unit,
    onClickAdopt: () -> Unit,
) {

    Scaffold(
        topBar = {
            DetailsTopBar(
                onClickArrowBack = onClickArrowBack
            )
        },
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            item {
                PetBasicInfoItem(animal = animal)
            }
            item {
                PetStoryItem(description = animal.description.toString())
            }
            item {
                PetInfoCard(animal = animal)
            }
            item {
                OwnerInfoCard(owner = animal.animalOwnerContact!!) {

                }
            }
            item {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    onClick = onClickAdopt,
                ) {
                    Text(text = "Adopt me")
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevDetailsScreen() {
    val animal = DummyPetDataSource.dogList[0]

    DetailsScreen(
        animal = animal,
        onClickArrowBack = {},
        onClickAdopt = {},
    )
}