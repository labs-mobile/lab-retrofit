package com.example.android.marsphotos.data

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("body")
    val content: String,
    val id: Int,
    val title: String,
    val userId: Int
)