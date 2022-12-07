package com.example.finalproject.userApi.user.di

import com.example.finalproject.userApi.user.data.api.ApiConstants
import com.example.finalproject.userApi.user.data.api.GetUsersAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserApiModule {
    @Provides
    @Singleton
    fun provideApi(builder:Retrofit.Builder):GetUsersAPI{
        return builder
            .build()
            .create(GetUsersAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
}