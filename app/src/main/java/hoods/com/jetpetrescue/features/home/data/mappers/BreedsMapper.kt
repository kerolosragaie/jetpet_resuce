package hoods.com.jetpetrescue.features.home.data.mappers

import hoods.com.jetpetrescue.features.home.data.remote.models.BreedsDto
import hoods.com.jetpetrescue.features.home.domain.models.Breeds

fun BreedsDto.fromDtoToModel(): Breeds = Breeds(
    primary = primary,
    secondary = secondary,
    mixed = mixed,
    unknown = unknown,
)