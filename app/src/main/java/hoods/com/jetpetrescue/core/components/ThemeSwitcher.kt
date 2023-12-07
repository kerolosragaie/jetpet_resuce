package hoods.com.jetpetrescue.core.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.R

@Composable
fun ThemeSwitcher(
    onSwitchToggle: () -> Unit,
) {
    val icon =
        if (isSystemInDarkTheme()) painterResource(id = R.drawable.ic_switch_on)
        else painterResource(id = R.drawable.ic_switch_off)

    IconButton(
        onClick = onSwitchToggle,
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .size(30.dp),
            tint = MaterialTheme.colors.onSurface,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrevThemeSwitcher() {
    ThemeSwitcher {

    }
}