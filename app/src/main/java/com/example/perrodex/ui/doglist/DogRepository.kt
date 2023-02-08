package com.example.perrodex.ui.doglist

import com.example.perrodex.R
import com.example.perrodex.model.Dog
import com.example.perrodex.model.dto.DogDTOMapper
import com.example.perrodex.network.ApiResponseStatus
import com.example.perrodex.network.DogsApi.retrofitService
import com.example.perrodex.network.makeNetworkCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class DogRepository {

    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>> = makeNetworkCall {
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapper = DogDTOMapper()
            dogDTOMapper.fromDogDTOListToDogDomainList(dogDTOList)
        }

}