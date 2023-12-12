package hoods.com.jetpetrescue.features.home.domain.models

import hoods.com.jetpetrescue.features.home.data.remote.models.BreedsDto

data class Pet(
    val id: Int ,
    val age: String,
    val breeds: BreedsDto,
    val colors: String,
    val petOwnerContact: PetOwnerContact,
    val description: String,
    val distance: String,
    val gender: String ,
    val name: String ,
    val photos: List<PetPhoto>,
    val size: String ,
    val species: String ,
    val status: String,
    val tags: List<String>,
    val type: String,
    val currentPage: Int,
)
