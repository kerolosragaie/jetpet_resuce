package hoods.com.jetpetrescue.features.home.data

import android.content.Context
import hoods.com.jetpetrescue.features.home.data.local.StoragePreference
import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.BASE_URL
import hoods.com.jetpetrescue.features.home.data.remote.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Graph {
    private lateinit var tokenStoragePreference: StoragePreference
    lateinit var apiService: ApiService

    fun provide(context: Context) {
        tokenStoragePreference = StoragePreference(context)
        apiService = provideApiService()
    }

    private fun provideApiService(): ApiService =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}