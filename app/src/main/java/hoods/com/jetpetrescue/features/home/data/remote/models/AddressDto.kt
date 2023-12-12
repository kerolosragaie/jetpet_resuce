package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class AddressDto(
    @SerializedName("address1")
    val address1: String? = null,
    @SerializedName("address2")
    val address2: String? = null,
    @SerializedName("city")
    val city: String ? = null,
    @SerializedName("state")
    val state: String ? = null,
    @SerializedName("postcode")
    val postcode: String ? = null,
    @SerializedName("country")
    val country: String ? = null,
)