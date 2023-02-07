package com.example.perrodex.network.responses

import com.squareup.moshi.Json

class DogListApiResponse(
    val message: String,
    @field:Json(name = "is_success")val isSuccess: Boolean,
    val data: DogListResponse
)