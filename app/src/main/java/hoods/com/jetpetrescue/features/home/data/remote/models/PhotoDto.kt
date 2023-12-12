package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("small")
    val small: String = "",
    @SerializedName("medium")
    val medium: String = "",
    @SerializedName("large")
    val large: String = "",
    @SerializedName("full")
    val full: String = ""
)