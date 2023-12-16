package hoods.com.jetpetrescue.features.home.presentation.screens.details.components

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import hoods.com.jetpetrescue.R
import hoods.com.jetpetrescue.core.components.GenderTag
import hoods.com.jetpetrescue.core.components.LoadingScreen
import hoods.com.jetpetrescue.core.components.LocationTag
import hoods.com.jetpetrescue.core.data.DummyPetDataSource
import hoods.com.jetpetrescue.features.home.domain.models.Animal


@Composable
fun PetBasicInfoItem(animal: Animal) {
    var isLoadingImage by remember { mutableStateOf(false) }

    Column {
        if (isLoadingImage)
            LoadingScreen(true)

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(340.dp),
            model = if (animal.photos!!.isNotEmpty())
                animal.photos.first().medium
            else
                null,
            error = painterResource(id = R.drawable.wiggle_logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.CenterStart,
            onLoading = { isLoadingImage = true },
            onError = { it.result.throwable.printStackTrace() },
            onSuccess = { isLoadingImage = false },
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
                    text = animal.name.toString(),
                    modifier = Modifier.padding(end = 12.dp),
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5,
                )
                Spacer(modifier = Modifier.height(8.dp))
                LocationTag(
                    location = animal.animalOwnerContact?.address.toString(),
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
                    gender = animal.gender.toString(),
                    modifier = Modifier
                )
                Text(
                    text = animal.type.toString(),
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
        animal = DummyPetDataSource.dogList.first()
    )
}