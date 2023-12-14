package hoods.com.jetpetrescue.features.home.data

import android.content.Context
import hoods.com.jetpetrescue.features.home.data.local.StoragePreference
import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.BASE_URL
import hoods.com.jetpetrescue.features.home.data.remote.api.ApiService
import hoods.com.jetpetrescue.features.home.data.remote.interceptors.AccessTokenAuthorization
import hoods.com.jetpetrescue.features.home.data.remote.interceptors.AuthInterceptorImpl
import hoods.com.jetpetrescue.features.home.data.remote.token.AccessTokenProvider
import hoods.com.jetpetrescue.features.home.data.remote.token.AccessTokenProviderImpl
import hoods.com.jetpetrescue.features.home.data.repo.PetRepoImpl
import hoods.com.jetpetrescue.features.home.domain.repo.PetRepo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Graph {
    private lateinit var tokenStoragePreference: StoragePreference
    lateinit var apiService: ApiService
    private lateinit var accessTokenProvider: AccessTokenProvider
    lateinit var petRepo: PetRepo
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient
            .Builder()
            .addInterceptor(logger)
            .addInterceptor(AuthInterceptorImpl(accessTokenProvider))
            .authenticator(AccessTokenAuthorization(accessTokenProvider))
            .build()
    }

    fun init(context: Context) {
        tokenStoragePreference = StoragePreference(context)
        accessTokenProvider = AccessTokenProviderImpl(tokenStoragePreference)
        apiService = provideApiService()
        petRepo = PetRepoImpl(apiService)
    }

    private fun provideApiService(): ApiService =
        Retrofit
            .Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}