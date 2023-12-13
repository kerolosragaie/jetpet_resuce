package hoods.com.jetpetrescue.features.home.presentation.screens.details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.core.data.DummyPetDataSource


@Composable
fun PetStoryItem(
    description:String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(
            text = "My story",
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.W600,
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = description,
            modifier = Modifier
                .fillMaxWidth(),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Start,
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevPetStory() {
    PetStoryItem(
        description = DummyPetDataSource.dogList.random().description.toString()
    )
}