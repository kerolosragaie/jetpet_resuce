package hoods.com.jetpetrescue.features.home


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.jetpetrescue.core.components.TopBar
import hoods.com.jetpetrescue.core.data.DummyPetDataSource
import hoods.com.jetpetrescue.features.home.components.PetInfoItem

@Composable
fun HomeScreen(
    onSwitchToggle: () -> Unit,
    onPetItemClicked: (Int) -> Unit,
) {
    val petList = DummyPetDataSource.dogList

    Scaffold(
        topBar = {
            TopBar(onSwitchToggle = onSwitchToggle)
        },
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues
        ) {
            itemsIndexed(petList) { index, pet ->
                PetInfoItem(pet = pet) {
                    onPetItemClicked.invoke(index)
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevHomeScreen() {
    HomeScreen(
        onSwitchToggle = {},
        onPetItemClicked = {},
    )
}