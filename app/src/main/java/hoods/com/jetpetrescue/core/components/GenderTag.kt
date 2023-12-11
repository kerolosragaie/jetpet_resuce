package hoods.com.jetpetrescue.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
[gender] by default is "Male" else will be "Female"
 */
@Composable
fun GenderTag(gender:String="Male",modifier: Modifier) {
    val color = if(gender=="Male") Color.Blue else Color.Red

    Box(
        modifier= modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(12.dp))
            .background(color.copy(alpha = .2f))
    ){
        Text(
            text=gender,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrevGenderTag() {
    GenderTag(modifier = Modifier)
}