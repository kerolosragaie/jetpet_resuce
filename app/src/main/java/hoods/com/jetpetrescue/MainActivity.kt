package hoods.com.jetpetrescue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.jetpetrescue.core.functions.Screen
import hoods.com.jetpetrescue.core.theme.JetPetTheme
import hoods.com.jetpetrescue.features.details.DetailsScreen
import hoods.com.jetpetrescue.features.home.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentScreen by remember { mutableStateOf(Screen.Home) }
            var selectedIndex by remember { mutableStateOf(-1) }
            var isDarkTheme by remember {mutableStateOf(false) }

            JetPetTheme(
                darkTheme = isDarkTheme,
            ){
                when (currentScreen) {
                    Screen.Home -> {
                        HomeScreen(
                            onSwitchToggle = {
                                isDarkTheme = !isDarkTheme
                            },
                            onPetItemClicked = { index ->
                                currentScreen = Screen.Details
                                selectedIndex = index
                            },
                        )
                    }

                    Screen.Details -> {
                        DetailsScreen(
                            index = selectedIndex,
                            onClickArrowBack = {
                                currentScreen = Screen.Home
                            },
                            onClickAdopt = {},
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
            onSwitchToggle = {

            },
            onPetItemClicked = {

            },
        )
    }
}