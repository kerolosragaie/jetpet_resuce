package hoods.com.jetpetrescue.features.home.data.remote.api

import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.API_KEY
import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.AUTH_END_POINT
import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.BASE_END_POINT
import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.CLIENT_CREDENTIALS
import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.CLIENT_ID
import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.CLIENT_SECRET
import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.GRANT_TYPE
import hoods.com.jetpetrescue.features.home.data.remote.models.AccessToken
import hoods.com.jetpetrescue.features.home.data.remote.models.AnimalsDto
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @GET(BASE_END_POINT)
    suspend fun getAnimals(
        @Query("page") page: Int,
    ): AnimalsDto

    @POST(AUTH_END_POINT)
    @FormUrlEncoded
    suspend fun getAuthToken(
        @Field(CLIENT_ID) clientId: String = API_KEY,
        @Field(CLIENT_SECRET) clientSecret: String = CLIENT_SECRET,
        @Field(GRANT_TYPE) grantType: String = CLIENT_CREDENTIALS,
    ): AccessToken

}