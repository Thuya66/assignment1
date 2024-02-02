package com.thuya.assignment01.services

import android.content.Context
import android.widget.Toast
import com.thuya.assignment01.model.PostX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServices {
    fun getPosts(context: Context, callback: (PostX) -> Unit){
        // Create a Retrofit instance with the base URL and
        // a GsonConverterFactory for parsing the response.
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(
            GsonConverterFactory.create()).build()

        val apiInterface: ApiInterface = retrofit.create<ApiInterface>(ApiInterface::class.java)

        val call: Call<PostX> = apiInterface.getPosts()

        call.enqueue(object : Callback<PostX> {
            // This is an anonymous inner class that implements the Callback interface.
            override fun onResponse(call: Call<PostX>, response: Response<PostX>) {
                // This method is called when the API response is received successfully.

                if(response.isSuccessful){
                    Toast.makeText(context, "Request Success", Toast.LENGTH_SHORT).show()

                    // If the response is successful, parse the
                    // response body to a DataModel object.
                    val posts: PostX = response.body() as PostX
                    // Call the callback function with the DataModel
                    // object as a parameter.
                    callback(posts)
                }
            }

            override fun onFailure(call: Call<PostX>, t: Throwable) {
                // This method is called when the API request fails.
                Toast.makeText(context, "Request Fail : $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}