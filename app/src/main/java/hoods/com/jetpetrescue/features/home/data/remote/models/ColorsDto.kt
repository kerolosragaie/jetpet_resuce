package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class ColorsDto(
    @SerializedName("primary")
    val primary: String? = null,
    @SerializedName("secondary")
    val secondary: String? = null,
    @SerializedName("tertiary")
    val tertiary: String? = null
)