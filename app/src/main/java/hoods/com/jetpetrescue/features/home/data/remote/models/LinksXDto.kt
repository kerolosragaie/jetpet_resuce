package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class LinksXDto(
    @SerializedName("next")
    val next: NextDto = NextDto()
)