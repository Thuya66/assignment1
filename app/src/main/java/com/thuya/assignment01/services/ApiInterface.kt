package com.thuya.assignment01.services

import com.thuya.assignment01.model.PostX
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<PostX>
}