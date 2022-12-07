package com.example.finalproject.userApi.user.data.api

import com.example.finalproject.userApi.user.data.api.model.User
import retrofit2.http.GET

interface GetUsersAPI {
    @GET(ApiConstants.GETUSERS)
    suspend fun getUsers():List<User>
}