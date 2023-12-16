package hoods.com.jetpetrescue.features.home.data.mappers

import hoods.com.jetpetrescue.features.home.data.remote.models.AnimalDto
import hoods.com.jetpetrescue.features.home.domain.models.Animal


fun AnimalDto.fromDtoToModel(currentPage: Int?): Animal = Animal(
    id = id,
    age = age,
    breeds = breeds?.fromDtoToModel(),
    colors = colorsDto?.fromDtoToModel(),
    currentPage = currentPage ?: 0,
    description = description,
    distance = distance.toString(),
    animalOwnerContact = contact?.fromDtoToModel(),
    gender = gender,
    name = name,
    photos = photos?.map { it.fromDtoToModel() },
    size = size,
    species = species,
    status = status,
    tags = tags,
    type = type,
    url = url,
)