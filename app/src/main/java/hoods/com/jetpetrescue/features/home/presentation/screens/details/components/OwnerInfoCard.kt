package hoods.com.jetpetrescue.features.home.presentation.screens.details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.jetpetrescue.R
import hoods.com.jetpetrescue.core.data.DummyPetDataSource
import hoods.com.jetpetrescue.core.data.model.Owner

@Composable
fun OwnerInfoCard(
    owner: Owner,
    onClickMessengerBttn: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = owner.image),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = owner.name,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Start,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = owner.basicInfo,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.caption,
                    textAlign = TextAlign.Start,
                )
            }
        }

        Surface(
            modifier = Modifier
                .size(40.dp)
                .clickable {}
                .clip(CircleShape)
                .background(Color.Red.copy(.2f)),
            shape = CircleShape,
            color = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
        ) {
            IconButton(onClick = onClickMessengerBttn) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_messenger),
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrevOwnerInfoCard() {
    OwnerInfoCard(
        owner = DummyPetDataSource.dogList.random().owner
    ){

    }
}