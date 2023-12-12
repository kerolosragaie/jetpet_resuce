package hoods.com.jetpetrescue.features.home.data.mappers

import hoods.com.jetpetrescue.features.home.data.remote.models.ContactDto
import hoods.com.jetpetrescue.features.home.domain.models.AnimalOwnerContact


fun ContactDto.fromDtoToModel(): AnimalOwnerContact = AnimalOwnerContact(
    phone = phone,
    address = addressDto?.let {
        "${it.country}, ${it.address1}"
    },
    email = email
)