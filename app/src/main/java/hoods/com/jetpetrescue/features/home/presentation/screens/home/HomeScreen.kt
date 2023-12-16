package hoods.com.jetpetrescue.features.home.presentation.screens.home


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.R
import hoods.com.jetpetrescue.core.components.ErrorScreen
import hoods.com.jetpetrescue.core.components.LoadingScreen
import hoods.com.jetpetrescue.core.utils.ResourceHolder
import hoods.com.jetpetrescue.features.home.presentation.screens.home.components.HomeTopBar
import hoods.com.jetpetrescue.features.home.presentation.screens.home.components.PetInfoItem

@Composable
fun HomeScreen(
    onSwitchToggle: () -> Unit,
    onPetItemClicked: (Int) -> Unit,
    homeViewModel: HomeViewModel,
) {
    val scrollState = rememberLazyListState()
    val uiState = homeViewModel.uiState

    Scaffold(
        topBar = {
            HomeTopBar(onSwitchToggle = onSwitchToggle)
        },
    ) { paddingValues ->

        when (uiState.animals) {
            is ResourceHolder.Loading -> {
                LoadingScreen()
            }

            is ResourceHolder.Success -> {
                LazyColumn(
                    contentPadding = paddingValues
                ) {
                    val animalsList = uiState.animals.data ?: emptyList()
                    itemsIndexed(animalsList) { index, animal ->
                        PetInfoItem(animal = animal) {
                            onPetItemClicked.invoke(index)
                        }
                        LaunchedEffect(key1 = scrollState) {
                            if (index >= animalsList.lastIndex
                                && uiState.isFetchingPet
                                && uiState.startInfiniteScrolling
                            ) {
                                homeViewModel.loadNextAnimalsPage()
                            }
                        }
                    }
                    if (uiState.isFetchingPet) {
                        item {
                            CircularProgressIndicator()
                        }
                    }
                    item {
                        AnimatedVisibility(
                            visible = uiState.moreBttnVisible
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                TextButton(
                                    onClick = {
                                        homeViewModel.loadNextAnimalsPage()
                                        homeViewModel.onInfiniteScrollChange(true)
                                    },
                                ) {
                                    Text(text = stringResource(id = R.string.loadMorePets))
                                }
                            }
                        }
                    }
                }

            }

            else -> {
                ErrorScreen(
                    message = uiState.animals.throwable?.message,
                    retryFunc = {
                        homeViewModel.loadNextAnimalsPage()
                    }
                )
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
        homeViewModel = HomeViewModel(),
    )
}