package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class AnimalDto(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("organization_id")
    val organizationId: String ? = null,
    @SerializedName("url")
    val url: String ? = null,
    @SerializedName("type")
    val type: String ? = null,
    @SerializedName("species")
    val species: String ? = null,
    @SerializedName("breeds")
    val breeds: BreedsDto ? = null,
    @SerializedName("colors")
    val colorsDto: ColorsDto? = null,
    @SerializedName("age")
    val age: String? = null,
    @SerializedName("gender")
    val gender: String ? = null,
    @SerializedName("size")
    val size: String ? = null,
    @SerializedName("coat")
    val coat: String? = null,
    @SerializedName("attributes")
    val attributesDto: AttributesDto ? = null,
    @SerializedName("environment")
    val environment: EnvironmentDto ? = null,
    @SerializedName("tags")
    val tags: List<String> ? = null,
    @SerializedName("name")
    val name: String ? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("organization_animal_id")
    val organizationAnimalId: String? = null,
    @SerializedName("photos")
    val photos: List<PhotoDto>? = null,
    @SerializedName("primary_photo_cropped")
    val primaryPhotoCropped: PrimaryPhotoCroppedDto? = null,
    @SerializedName("videos")
    val videos: List<Any> ? = null,
    @SerializedName("status")
    val status: String ? = null,
    @SerializedName("status_changed_at")
    val statusChangedAt: String ? = null,
    @SerializedName("published_at")
    val publishedAt: String? = null,
    @SerializedName("distance")
    val distance: Any? = null,
    @SerializedName("contact")
    val contact: ContactDto? = null,
    @SerializedName("_links")
    val linksDto: LinksDto ? = null,
)