/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.marsphotos.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.marsphotos.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PostRepository() {

    var isLoading : MutableLiveData<Boolean> = MutableLiveData(false)


    var resault = ""


    fun FindAll(){

        this.isLoading.value = true

        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PostApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<Post>?> {
            override fun onResponse(
                call: Call<List<Post>?>,
                response: Response<List<Post>?>
            ) {
                val responseBody = response.body()!!

                val stringBuilder = StringBuilder()
                for (myData in responseBody){
                    stringBuilder.append(myData.title)
                    stringBuilder.append("\n")
                }
                resault = stringBuilder.toString()
                isLoading.value = false


            }

            override fun onFailure(call: Call<List<Post>?>, t: Throwable) {
                resault = "on Failure " + t.message
            }
        })



    }


//    private fun getMyData(binding: ActivityMainBinding) {
//        val BASE_URL = "https://jsonplaceholder.typicode.com/"
//
//        val retrofitBuilder = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//            .create(PostApiInterface::class.java)
//        val retrofitData = retrofitBuilder.getData()
//
//        retrofitData.enqueue(object : Callback<List<Post>?> {
//            override fun onResponse(
//                call: Call<List<Post>?>,
//                response: Response<List<Post>?>
//            ) {
//                val responseBody = response.body()!!
//
//                val stringBuilder = StringBuilder()
//                for (myData in responseBody){
//                    stringBuilder.append(myData.title)
//                    stringBuilder.append("\n")
//                }
//                binding.textView.text = stringBuilder
//
//
//            }
//
//            override fun onFailure(call: Call<List<Post>?>, t: Throwable) {
//                binding.textView.text = "on Failure " + t.message
//            }
//        })
//    }




}
