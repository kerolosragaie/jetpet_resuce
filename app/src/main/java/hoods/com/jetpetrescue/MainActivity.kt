package hoods.com.jetpetrescue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.jetpetrescue.core.theme.JetPetTheme
import hoods.com.jetpetrescue.features.home.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPetTheme {
                HomeScreen(
                    onSwitchToggle = {

                    },
                    onPetItemClicked = {

                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
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