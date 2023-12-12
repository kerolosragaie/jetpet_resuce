package hoods.com.jetpetrescue.features.home.data.remote.token

import hoods.com.jetpetrescue.features.home.data.remote.models.AccessToken

interface AccessTokenProvider {
    suspend fun fetchAccessToken(): AccessToken?

    fun refreshToken(): AccessToken?

    fun saveToken(token: String?)

    fun token(): String?
    fun lock(): Any

}