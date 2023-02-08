package com.example.perrodex.network

import com.example.perrodex.BASE_URL
import com.example.perrodex.GET_ALL_DOGS_URL
import com.example.perrodex.SIGN_UP_URL
import com.example.perrodex.model.dto.SignUpDTO
import com.example.perrodex.network.responses.DogListApiResponse
import com.example.perrodex.network.responses.SignUpApiResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiService{
    @GET(GET_ALL_DOGS_URL)
    suspend fun getAllDogs(): DogListApiResponse

    @POST(SIGN_UP_URL)
    suspend fun signUp(@Body signUpDTO: SignUpDTO): SignUpApiResponse
}

object DogsApi{
    val retrofitService: ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }

}