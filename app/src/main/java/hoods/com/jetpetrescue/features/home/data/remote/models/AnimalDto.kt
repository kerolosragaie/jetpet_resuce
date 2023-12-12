package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class AnimalDto(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("organization_id")
    val organizationId: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("species")
    val species: String = "",
    @SerializedName("breeds")
    val breeds: BreedsDto = BreedsDto(),
    @SerializedName("colors")
    val colorsDto: ColorsDto = ColorsDto(),
    @SerializedName("age")
    val age: String = "",
    @SerializedName("gender")
    val gender: String = "",
    @SerializedName("size")
    val size: String = "",
    @SerializedName("coat")
    val coat: String? = null,
    @SerializedName("attributes")
    val attributesDto: AttributesDto = AttributesDto(),
    @SerializedName("environment")
    val environment: EnvironmentDto = EnvironmentDto(),
    @SerializedName("tags")
    val tags: List<String> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("organization_animal_id")
    val organizationAnimalId: String? = null,
    @SerializedName("photos")
    val photos: List<PhotoDto> = listOf(),
    @SerializedName("primary_photo_cropped")
    val primaryPhotoCropped: PrimaryPhotoCroppedDto? = null,
    @SerializedName("videos")
    val videos: List<Any> = listOf(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("status_changed_at")
    val statusChangedAt: String = "",
    @SerializedName("published_at")
    val publishedAt: String = "",
    @SerializedName("distance")
    val distance: Any? = null,
    @SerializedName("contact")
    val contact: ContactDto = ContactDto(),
    @SerializedName("_links")
    val linksDto: LinksDto = LinksDto()
)