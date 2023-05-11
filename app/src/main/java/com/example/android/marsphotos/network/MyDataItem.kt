package com.example.android.marsphotos.network

import com.google.gson.annotations.SerializedName

data class MyDataItem(
    @SerializedName("body")
    val content: String,
    val id: Int,
    val title: String,
    val userId: Int
)