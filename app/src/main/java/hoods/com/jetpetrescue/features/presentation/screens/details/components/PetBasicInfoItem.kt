package hoods.com.jetpetrescue.features.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.core.components.GenderTag
import hoods.com.jetpetrescue.core.components.LocationTag
import hoods.com.jetpetrescue.core.data.DummyPetDataSource
import hoods.com.jetpetrescue.core.data.model.Pet


@Composable
fun PetBasicInfoItem(
    pet: Pet,
) {
    Column{
        Image(
            painter = painterResource(id = pet.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(340.dp),
            alignment = Alignment.CenterStart,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = pet.name,
                    modifier = Modifier.padding(end = 12.dp),
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5,
                )
                Spacer(modifier = Modifier.height(8.dp))
                LocationTag(
                    location = pet.location,
                    verticalAlignment = Alignment.Bottom,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Adoptable",
                    modifier = Modifier.padding(end = 12.dp),
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.overline,
                )
            }
            Column(
                modifier = Modifier.height(80.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                GenderTag(
                    gender = pet.gender,
                    modifier = Modifier
                )
                Text(
                    text = "Dog",
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PrevTopBasicInfo() {
    PetBasicInfoItem(
        pet = DummyPetDataSource.dogList.random()
    )
}