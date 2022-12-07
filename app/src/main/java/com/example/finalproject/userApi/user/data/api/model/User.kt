package com.example.finalproject.userApi.user.data.api.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class User(
    @SerializedName("username")
    val username:String,
    @SerializedName("password")
    val password:String
)
