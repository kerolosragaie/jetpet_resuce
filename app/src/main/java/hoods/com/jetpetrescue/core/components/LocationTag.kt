package hoods.com.jetpetrescue.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.R

@Composable
fun LocationTag(
    location: String,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalAlignment: Alignment.Vertical = Alignment.Bottom,
) {
    Row(
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment,
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = null,
            tint = MaterialTheme.colors.error
        )
        Text(
            text = location,
            modifier = Modifier.padding(
                start = 8.dp,
                top = 0.dp,
                end = 12.dp,
                bottom = 0.dp,
            ),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.caption,
        )
    }
}


@Preview
@Composable
fun PrevLocationTag() {
    LocationTag(
        location = "Vienna"
    )
}