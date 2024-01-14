package com.example.myapplication.hw21.repository

import retrofit2.Callback
import javax.sql.DataSource

class DetailsRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
):DetailsRepository {
    override fun getCourseDetails(
        currencies: String,
        source: String,
        callback: Callback<CourseDTO>
    ) {
        remoteDataSource.getCourseDetails(currencies,source,callback)
    }
}