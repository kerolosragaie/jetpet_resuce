package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class LinksDto(
    @SerializedName("self")
    val self: SelfDto = SelfDto(),
    @SerializedName("type")
    val type: TypeDto = TypeDto(),
    @SerializedName("organization")
    val organization: OrganizationDto = OrganizationDto()
)