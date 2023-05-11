package com.example.android.marsphotos.data

import retrofit2.Call
import retrofit2.http.GET

interface PostApiInterface {

    @GET("posts")
    fun getData() : Call<List<Post>>
}
