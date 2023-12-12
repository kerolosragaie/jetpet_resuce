package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class AnimalsDto(
    @SerializedName("animals")
    val animalDtos: List<AnimalDto> = listOf(),
    @SerializedName("pagination")
    val pagination: PaginationDto = PaginationDto()
)