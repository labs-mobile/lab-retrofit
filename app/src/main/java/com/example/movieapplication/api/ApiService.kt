package com.example.movieapplication.api

import com.example.movieapplication.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}