package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class EnvironmentDto(
    @SerializedName("children")
    val children: Boolean? = null,
    @SerializedName("dogs")
    val dogs: Boolean? = null,
    @SerializedName("cats")
    val cats: Boolean? = null
)