package hoods.com.jetpetrescue.features.home.presentation.screens.details.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun DetailsTopBar(
    title: String = "Detail",
    onClickArrowBack: () -> Unit,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onSurface,
        navigationIcon = {
            IconButton(onClick = onClickArrowBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
            }
        },
        title = {
            Text(
                text = title,
            )
        },
        actions = actions,
    )
}

@Preview
@Composable
fun PrevDetailsTopBar() {
    DetailsTopBar(
        onClickArrowBack = {},
    )
}