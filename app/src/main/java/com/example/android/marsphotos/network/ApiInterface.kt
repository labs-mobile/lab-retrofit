package com.example.android.marsphotos.network

import retrofit2.Call
import retrofit2.http.GET



//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
//
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .build()


interface ApiInterface {

    @GET("posts")
    fun getData() : Call<List<MyDataItem>>
}
