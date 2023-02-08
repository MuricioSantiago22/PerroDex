package com.example.perrodex.model.dto

import com.example.perrodex.model.User

class UserDTOMapper {
    fun fromUserDTOToUserDomain(userDTO: UserDTO)=
        User(userDTO.id, userDTO.email, userDTO.authenticationToken)
    }
