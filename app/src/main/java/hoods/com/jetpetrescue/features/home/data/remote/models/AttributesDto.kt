package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class AttributesDto(
    @SerializedName("spayed_neutered")
    val spayedNeutered: Boolean = false,
    @SerializedName("house_trained")
    val houseTrained: Boolean = false,
    @SerializedName("declawed")
    val declawed: Boolean? = null,
    @SerializedName("special_needs")
    val specialNeeds: Boolean = false,
    @SerializedName("shots_current")
    val shotsCurrent: Boolean = false
)