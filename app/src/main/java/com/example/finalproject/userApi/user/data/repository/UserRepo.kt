package com.example.finalproject.userApi.user.data.repository

import com.example.finalproject.userApi.user.data.api.GetUsersAPI
import com.example.finalproject.userApi.user.data.api.model.User
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val usersAPI: GetUsersAPI
) {
    suspend fun getUsers():List<User>{
        return usersAPI.getUsers()
    }

}