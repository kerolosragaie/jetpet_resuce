package hoods.com.jetpetrescue.features.home.data.remote.models


import com.google.gson.annotations.SerializedName

data class AccessToken(
    @SerializedName("token_type")
    val tokenType: String? = null,
    @SerializedName("expires_in")
    val expiresIn: Int? = null,
    @SerializedName("access_token")
    val accessToken: String? = null,
)