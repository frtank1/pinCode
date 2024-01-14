package com.example.myapplication.hw21.repository

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MoneyAPI {
    @GET("/list")
    fun getCourse(
        @Header("access_key") token: String,
        @Query("currencies") currencies:String,
        @Query("source") source:String,
        @Query("format ") format:Int
    ): Call<CourseDTO>

}