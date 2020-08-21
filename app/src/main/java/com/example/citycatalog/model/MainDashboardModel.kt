package com.example.citycatalog.model

import java.io.Serializable

data class MainDashboardModel(
    val cityMain: String,
    val imageUrlMain: String,
    val cityId: Int
) : Serializable