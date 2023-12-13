package hoods.com.jetpetrescue.features.home.presentation.screens.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.jetpetrescue.core.theme.JetPetTheme
import hoods.com.jetpetrescue.core.utils.Screen
import hoods.com.jetpetrescue.features.home.presentation.screens.details.DetailsScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val homeViewModel by viewModels<HomeViewModel>()
            var currentScreen by remember { mutableStateOf(Screen.Home) }
            var selectedIndex by remember { mutableStateOf(-1) }
            var isDarkTheme by remember { mutableStateOf(false) }

            JetPetTheme(
                darkTheme = isDarkTheme,
            ) {
                when (currentScreen) {
                    Screen.Home -> {
                        HomeScreen(
                            uiState = homeViewModel.uiState,
                            onSwitchToggle = {
                                isDarkTheme = !isDarkTheme
                            },
                            onPetItemClicked = { index ->
                                currentScreen = Screen.Details
                                selectedIndex = index
                            },
                            onLoadNextPage = {
                                homeViewModel.loadNextAnimalsPage()
                            },
                            onInfiniteScrollingChange = {
                                homeViewModel.onInfiniteScrollChange(it)
                            }
                        )
                    }

                    Screen.Details -> {
                        DetailsScreen(
                            animal = homeViewModel.uiState.animals.data?.get(selectedIndex)!!,
                            onClickArrowBack = {
                                currentScreen = Screen.Home
                            },
                            onClickAdopt = {

                            },
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetPetTheme {
        HomeScreen(
            uiState = UiState(),
            onSwitchToggle = {
            },
            onPetItemClicked = { index ->

            },
            onLoadNextPage = {
            },
            onInfiniteScrollingChange = {
            }
        )
    }
}