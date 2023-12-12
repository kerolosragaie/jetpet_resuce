package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class LinksDto(
    @SerializedName("self")
    val self: SelfDto ? = null,
    @SerializedName("type")
    val type: TypeDto ? = null,
    @SerializedName("organization")
    val organization: OrganizationDto ? = null,
)