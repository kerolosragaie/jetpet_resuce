package hoods.com.jetpetrescue.core.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoadingScreen(showProgressIndicatorOnly: Boolean = false) {
    if (showProgressIndicatorOnly) {
        CircularProgressIndicator(
            Modifier.wrapContentSize(Alignment.Center)
        )
    } else {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            CircularProgressIndicator(
                Modifier.wrapContentSize(Alignment.Center)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoadingScreenPreview() {
    LoadingScreen(true)
}