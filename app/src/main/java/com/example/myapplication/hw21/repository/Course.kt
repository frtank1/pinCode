package com.example.myapplication.hw21.repository


data class CourseDTO(

    val success: Boolean?,

    val terms: String?,

    val privacy: String?,

    val timestamp: Int?,

    val source: String?,

    val quotes: Quotes?
) {

    data class Quotes(

        val uSDAED: Double?,

        val uSDAFN: Double?,

        val uSDALL: Double?,

        val uSDAMD: Double?,

        val uSDANG: Double?,

        val uSDAOA: Double?,

        val uSDARS: Double?,

        val uSDAUD: Double?,

        val uSDAWG: Double?,

        val uSDAZN: Double?,

        val uSDBAM: Double?
    )
}