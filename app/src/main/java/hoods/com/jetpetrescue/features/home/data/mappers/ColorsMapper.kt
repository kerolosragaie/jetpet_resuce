package hoods.com.jetpetrescue.features.home.data.mappers

import hoods.com.jetpetrescue.features.home.data.remote.models.ColorsDto
import hoods.com.jetpetrescue.features.home.domain.models.Colors


fun ColorsDto.fromDtoToModel(): Colors = Colors(
    primary = primary,
    secondary = secondary,
    tertiary = tertiary.toString(),
)