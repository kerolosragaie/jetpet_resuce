package hoods.com.jetpetrescue.features.details

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import hoods.com.jetpetrescue.features.details.components.DetailsTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsScreen(
    onClickArrowBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            DetailsTopBar(
                onClickArrowBack = onClickArrowBack
            )
        },
    ) { paddingValues ->

    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevDetailsScreen() {
    DetailsScreen(){}
}