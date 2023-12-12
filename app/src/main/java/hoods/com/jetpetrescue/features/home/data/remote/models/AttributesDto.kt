package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class AttributesDto(
    @SerializedName("spayed_neutered")
    val spayedNeutered: Boolean? = null,
    @SerializedName("house_trained")
    val houseTrained: Boolean ? = null,
    @SerializedName("declawed")
    val declawed: Boolean? = null,
    @SerializedName("special_needs")
    val specialNeeds: Boolean? = null,
    @SerializedName("shots_current")
    val shotsCurrent: Boolean ? = null,
)