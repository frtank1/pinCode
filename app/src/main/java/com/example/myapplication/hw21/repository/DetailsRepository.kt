package com.example.myapplication.hw21.repository

import retrofit2.Callback

interface DetailsRepository {
    fun getCourseDetails(
        currencies: String,
        source: String,
        callback:retrofit2.Callback<CourseDTO>
    )
}