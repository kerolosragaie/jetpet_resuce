package hoods.com.jetpetrescue.features.home.data.remote.api

import hoods.com.jetpetrescue.features.home.data.remote.RemoteConstants.BASE_END_POINT
import hoods.com.jetpetrescue.features.home.data.remote.models.AnimalsDto
import retrofit2.http.GET

interface ApiService {

    @GET(BASE_END_POINT)
    suspend fun getAnimals(): AnimalsDto

}