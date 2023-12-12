package hoods.com.jetpetrescue.features.home.data.mappers

import hoods.com.jetpetrescue.features.home.data.remote.models.PhotoDto
import hoods.com.jetpetrescue.features.home.domain.models.AnimalPhoto


fun PhotoDto.fromDtoToModel(): AnimalPhoto = AnimalPhoto(
    small = small,
    medium = medium,
    large = large,
    full = full,
)