package hoods.com.jetpetrescue.features.details

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
import hoods.com.jetpetrescue.features.details.components.DetailsTopBar
import hoods.com.jetpetrescue.features.details.components.OwnerInfoCard
import hoods.com.jetpetrescue.features.details.components.PetBasicInfoItem
import hoods.com.jetpetrescue.features.details.components.PetInfoCard
import hoods.com.jetpetrescue.features.details.components.PetStoryItem

@Composable
fun DetailsScreen(
    index: Int,
    onClickArrowBack: () -> Unit,
    onClickAdopt: () -> Unit,
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
                PetStoryItem(description = pet.description)
            }
            item {
                PetInfoCard(pet = pet)
            }
            item {
                OwnerInfoCard(owner = pet.owner) {

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
    DetailsScreen(
        index = 0,
        onClickArrowBack = {},
        onClickAdopt = {},
    )
}