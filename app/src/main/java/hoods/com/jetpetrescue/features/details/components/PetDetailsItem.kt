package hoods.com.jetpetrescue.features.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.jetpetrescue.core.data.DummyPetDataSource
import hoods.com.jetpetrescue.core.data.model.Pet

//TODO build

@Composable
fun PetDetailsItem(pet: Pet) {
    Column {

    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevPetDetailsItem() {
    PetDetailsItem(
        pet = DummyPetDataSource.dogList.random()
    )
}