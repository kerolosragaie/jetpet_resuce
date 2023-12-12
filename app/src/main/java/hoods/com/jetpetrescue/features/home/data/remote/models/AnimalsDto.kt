package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class AnimalsDto(
    @SerializedName("animals")
    val animalsDto: List<AnimalDto>? = null,
    @SerializedName("pagination")
    val pagination: PaginationDto ? = null,
)