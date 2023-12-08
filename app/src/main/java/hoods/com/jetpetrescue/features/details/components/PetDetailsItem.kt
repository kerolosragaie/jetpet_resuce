package hoods.com.jetpetrescue.features.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.core.data.DummyPetDataSource
import hoods.com.jetpetrescue.core.data.model.Pet

@Composable
fun PetDetailsItem(pet: Pet) {
    Column {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Pet info",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            InfoCard(
                primaryText = "Age",
                secondaryText = pet.age,
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            )

            InfoCard(
                primaryText = "Color",
                secondaryText = pet.color,
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            )

            InfoCard(
                primaryText = "Breed",
                secondaryText = pet.breed,
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            )
        }

    }
}

@Composable
fun InfoCard(
    modifier: Modifier = Modifier,
    primaryText: String,
    secondaryText: String,
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CompositionLocalProvider(
                LocalContentAlpha provides ContentAlpha.disabled
            ) {
                Text(text = primaryText)
            }
            Text(
                text = secondaryText,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }

    }

}


@Preview(showSystemUi = true)
@Composable
fun PrevPetDetailsItem() {
    PetDetailsItem(
        pet = DummyPetDataSource.dogList.random()
    )
}