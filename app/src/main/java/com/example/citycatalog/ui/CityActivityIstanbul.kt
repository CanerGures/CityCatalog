package com.example.citycatalog.ui

import android.animation.ArgbEvaluator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.citycatalog.R
import com.example.citycatalog.adapter.ViewPagerAdapter
import com.example.citycatalog.model.Model

class CityActivityIstanbul : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var adapter: PagerAdapter
    lateinit var feature: Model
    lateinit var rgbevaluator: ArgbEvaluator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_istanbul)

        val list = ArrayList<Model>()

        val card1 = Model(
            R.drawable.image5,
            "Lorem",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        )
        val card2 = Model(
            R.drawable.image5,
            "Lorem",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        )
        val card3 = Model(
            R.drawable.image5,
            "Lorem",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        )
        val card4 = Model(
            R.drawable.image5,
            "Lorem",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        )

        list.add(card1)
        list.add(card2)
        list.add(card3)
        list.add(card4)



        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(list)
        viewPager.setPadding(130, 0, 130, 0)
        viewPager.offscreenPageLimit = 3

        //viewPager.setOnPageChangeListener()
    }


}