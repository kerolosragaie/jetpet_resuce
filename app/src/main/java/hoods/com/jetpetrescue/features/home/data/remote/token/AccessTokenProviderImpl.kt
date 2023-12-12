package hoods.com.jetpetrescue.features.home.data.remote.token

import hoods.com.jetpetrescue.features.home.data.Graph
import hoods.com.jetpetrescue.features.home.data.local.StoragePreference
import hoods.com.jetpetrescue.features.home.data.remote.models.AccessToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccessTokenProviderImpl(
    private val storagePreference: StoragePreference,
) : AccessTokenProvider {
    override suspend fun fetchAccessToken(): AccessToken = withContext(Dispatchers.IO) {
        val accessToken = Graph.apiService.getAuthToken()
        saveToken(accessToken.accessToken)
        accessToken
    }

    override fun refreshToken(): AccessToken? {
        return null
    }

    override fun saveToken(token: String?) {
        storagePreference.saveToken(token)
    }

    override fun token(): String = storagePreference.getToken()

    override fun lock(): Any = this
}