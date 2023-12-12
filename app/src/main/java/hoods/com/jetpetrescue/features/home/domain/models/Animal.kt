package hoods.com.jetpetrescue.features.home.domain.models

data class Animal(
    val id: Int?,
    val age: String?,
    val breeds: Breeds?,
    val colors: Colors?,
    val animalOwnerContact: AnimalOwnerContact?,
    val description: String?,
    val distance: String?,
    val gender: String?,
    val name: String?,
    val photos: List<AnimalPhoto>?,
    val size: String?,
    val species: String?,
    val status: String?,
    val tags: List<String>?,
    val type: String?,
    val currentPage: Int,
)
