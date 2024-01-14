package com.example.myapplication.hw21.repository

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Callback
object RemoteDataSource {
    private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

    private val courseApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        )
        .build().create(MoneyAPI::class.java)

    fun getCourseDetails(currencies: String, source: String, callback:
    Callback<CourseDTO>) {
        courseApi.getCourse("a1bbd8ddb1a52af85214a198bddfbd4e", currencies,
            source,1).enqueue(callback)
    }

}