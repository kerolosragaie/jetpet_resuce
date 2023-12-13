package hoods.com.jetpetrescue.features.home.presentation.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import hoods.com.jetpetrescue.R
import hoods.com.jetpetrescue.core.components.GenderTag
import hoods.com.jetpetrescue.core.components.LocationTag
import hoods.com.jetpetrescue.core.data.DummyPetDataSource
import hoods.com.jetpetrescue.features.home.domain.models.Animal

@Composable
fun PetInfoItem(
    animal: Animal,
    onItemClick: (Animal) -> Unit,
) {
    var isLoadingImage by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { onItemClick(animal) }),
        elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                if (isLoadingImage) {
                    CircularProgressIndicator()
                }
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp, 80.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    model = if (animal.photos!!.isNotEmpty())
                        animal.photos.first().medium
                    else
                        null,
                    placeholder = painterResource(id = R.drawable.placeholder_ic),
                    error = painterResource(id = R.drawable.placeholder_ic),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.CenterStart,
                    onLoading = { isLoadingImage = true },
                    onError = { it.result.throwable.printStackTrace() },
                    onSuccess = { isLoadingImage = false },
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = animal.name.toString(),
                        color = MaterialTheme.colors.onSurface,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.subtitle1,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = buildString {
                            append(animal.age)
                            append(" | ")
                            append(animal.breeds)
                        },
                        color = MaterialTheme.colors.onSurface,
                        style = MaterialTheme.typography.caption,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LocationTag(
                        location = animal.animalOwnerContact?.address.toString()
                    )
                }

            }
            Column(
                modifier = Modifier.height(80.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                GenderTag(gender = animal.gender.toString(), modifier = Modifier)
                Text(
                    text = "Adoptable",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevPetInfoItem() {
    val petItem = DummyPetDataSource.dogList[0]
    PetInfoItem(petItem) {}
}