package com.example.quizbanktest.network

import retrofit.Call
import retrofit.http.*
import retrofit2.http.Headers

interface ScanImageService {

    data class PostBody(val image: String)

    @POST("/scanner")
    fun scanBase64(
        @Header("X-CSRF-Token") csrfToken: String,
        @Header("access_token") accessToken: String,
        @Body body: PostBody
    ): Call<String>
}