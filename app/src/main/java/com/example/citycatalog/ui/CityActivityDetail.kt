package com.example.citycatalog.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.citycatalog.R
import com.example.citycatalog.model.TravelLocationModel

class CityActivityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)

        val headerImage: ImageView = findViewById(R.id.header_image)
        val textViewContent: TextView = findViewById(R.id.textView)
        val textViewTopic: TextView = findViewById(R.id.textView2)

        val cityObject = intent.extras?.get("cityObject") as TravelLocationModel

        textViewContent.text = cityObject.info
        textViewTopic.text = "Explore the " + cityObject.location
        Glide.with(this)
            .load(cityObject.imageUrl)
            .fitCenter()
            .into(headerImage)

    }
}