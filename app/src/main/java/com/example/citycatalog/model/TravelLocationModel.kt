package com.example.citycatalog.model

import java.io.Serializable

data class TravelLocationModel(
    val title: String,
    val location: String,
    val imageUrl: String,
    val starRating: Float,
    val id: Int,
    val info: String
) : Serializable