package hoods.com.jetpetrescue.features.home.data.mappers

import hoods.com.jetpetrescue.features.home.data.remote.models.AnimalPhotoDto
import hoods.com.jetpetrescue.features.home.domain.models.AnimalPhoto


fun AnimalPhotoDto.fromDtoToModel(): AnimalPhoto = AnimalPhoto(
    small = small,
    medium = medium,
    large = large,
    full = full,
)