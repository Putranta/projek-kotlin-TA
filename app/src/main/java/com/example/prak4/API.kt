package com.example.prak4

import retrofit2.Call
import retrofit2.http.GET

interface API {
    @GET("api/post")
    fun getPosts(): Call<ArrayList<PostResponseDataClass>>
}