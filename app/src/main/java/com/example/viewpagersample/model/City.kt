package com.example.viewpagersample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val cityName: String,
    val imageResourceId: Int,
    val cityFact: String
) : Parcelable