package com.example.myapplication.hw19.model

import android.os.Parcelable
import com.example.myapplication.R
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie(
    val id: Int = 125,
    val imageUrl: Int =  R.drawable.group46,
    val name: String = "Spider",
    val year: Int = 1995,
    val description: String = "becouse",
    val rating: Double = 12.0,
    var note:String = ""
) : Parcelable

fun getDefultCityArray() = listOf(Movie(), Movie(), Movie(), Movie(), Movie())
