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
import androidx.navigation.compose.rememberNavController
import hoods.com.jetpetrescue.core.navigation.NavGraph
import hoods.com.jetpetrescue.core.theme.JetPetTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val homeViewModel by viewModels<HomeViewModel>()
            var isDarkTheme by remember { mutableStateOf(false) }
            val navController = rememberNavController()

            JetPetTheme(
                darkTheme = isDarkTheme,
            ) {
                NavGraph(
                    navController = navController,
                    onThemeChange = { isDarkTheme = !isDarkTheme },
                    homeViewModel = homeViewModel,
                )
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
            onPetItemClicked = { _ ->

            },
            homeViewModel = HomeViewModel(),
        )
    }
}