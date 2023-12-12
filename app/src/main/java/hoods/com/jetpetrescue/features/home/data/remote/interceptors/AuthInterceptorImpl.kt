package hoods.com.jetpetrescue.features.home.data.remote.interceptors

import hoods.com.jetpetrescue.features.home.data.remote.token.AccessTokenProvider
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptorImpl(
    private val accessTokenProvider: AccessTokenProvider
) : Interceptor {

    companion object {
        const val TAG = "JetPetApp"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().signedRequest()
        return chain.proceed(newRequest)
    }

    private fun Request.signedRequest(): Request {
        return newBuilder()
            .addHeader(
                "Authorization",
                "Bearer ${accessTokenProvider.token()}",
            )
            .build()
    }

}