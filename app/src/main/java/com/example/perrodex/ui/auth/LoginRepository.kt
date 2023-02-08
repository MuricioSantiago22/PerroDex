package com.example.perrodex.ui.auth

import com.example.perrodex.model.Dog
import com.example.perrodex.model.User
import com.example.perrodex.model.dto.DogDTOMapper
import com.example.perrodex.model.dto.SignUpDTO
import com.example.perrodex.model.dto.UserDTOMapper
import com.example.perrodex.network.ApiResponseStatus
import com.example.perrodex.network.DogsApi
import com.example.perrodex.network.makeNetworkCall

class LoginRepository {

    suspend fun signUp(email: String, password: String, passwordConfirmation: String): ApiResponseStatus<User> = makeNetworkCall {
        val signupDTO = SignUpDTO(email, password, passwordConfirmation)
            val signUpResponse = DogsApi.retrofitService.signUp(signupDTO)

        if(!signUpResponse.isSuccess){
            throw Exception(signUpResponse.message)
        }
            val userDTO =signUpResponse.data.user
            val userDTOMapper = UserDTOMapper()
            userDTOMapper.fromUserDTOToUserDomain(userDTO)
        }

}