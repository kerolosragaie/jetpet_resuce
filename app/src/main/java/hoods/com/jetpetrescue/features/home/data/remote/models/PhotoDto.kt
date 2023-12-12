package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("small")
    val small: String ? = null,
    @SerializedName("medium")
    val medium: String ? = null,
    @SerializedName("large")
    val large: String ? = null,
    @SerializedName("full")
    val full: String? = null,
)