package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class BreedsDto(
    @SerializedName("primary")
    val primary: String = "",
    @SerializedName("secondary")
    val secondary: String? = null,
    @SerializedName("mixed")
    val mixed: Boolean = false,
    @SerializedName("unknown")
    val unknown: Boolean = false
)