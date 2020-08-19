package com.example.citycatalog.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.citycatalog.R
import com.example.citycatalog.adapter.ViewPagerAdapterCities
import com.example.citycatalog.model.TravelLocationModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs

class CityActivityBolivia : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var adapter: PagerAdapter
    lateinit var compositePageTransformer: CompositePageTransformer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_bolivia)

        viewPager = findViewById(R.id.locationsViewPager)
        val hawaiiFab: FloatingActionButton = findViewById(R.id.blFloatingActionButtonHawaii)
        val istanbulFab: FloatingActionButton = findViewById(R.id.blFloatingActionButtonTR)
        val boliviaFab: FloatingActionButton = findViewById(R.id.blFloatingActionButtonBolivia)
        val newYorkFab: FloatingActionButton = findViewById(R.id.blFloatingActionButtonABD)
        val mainFab: FloatingActionButton = findViewById(R.id.mainFab)
        val openFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val closeFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        var isOpen = false

        val list = ArrayList<TravelLocationModel>()

        val card11 = TravelLocationModel(
            "Bolivia",
            "Salar de Uyuni",
            "https://daily.jstor.org/wp-content/uploads/2015/08/Solar_de_Uyuni_1050x700.jpg",
            4.8f,
            11
        )
        val card12 = TravelLocationModel(
            "Bolivia",
            "Sajama National Park",
            "https://img.locationscout.net/images/2019-04/sajama-national-park-bolivia_l.jpeg",
            4.5f,
            12
        )
        val card13 = TravelLocationModel(
            "Bolivia",
            "La Glorieta Castle, Sucre",
            "https://media-cdn.tripadvisor.com/media/photo-s/0b/48/2c/fb/torres.jpg",
            4.9f,
            13
        )
        val card14 = TravelLocationModel(
            "Bolivia",
            "Death Road, La Paz",
            "https://cms.hostelworld.com/hwblog/wp-content/uploads/sites/2/2019/10/best-places-to-visit-in-Bolivia-Matthew-Straubmuller-Death-Road.jpg",
            4.4f,
            14
        )
        val card15 = TravelLocationModel(
            "Bolivia",
            "Mount Illimani, La Paz",
            "https://cms.hostelworld.com/hwblog/wp-content/uploads/sites/2/2019/10/best-places-to-visit-in-Bolivia-@akhamani-llimani.jpg",
            4.6f,
            15
        )
        list.add(card11)
        list.add(card12)
        list.add(card13)
        list.add(card14)
        list.add(card15)

        viewPager.adapter = ViewPagerAdapterCities(list)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { view: View, fl: Float ->
            fun transformPage(page: View, position: Float) {
                val r = 1 - abs(position)
                page.scaleY = 0.95f + r * 0.05f
            }
        })

        viewPager.setPageTransformer(compositePageTransformer)

        mainFab.setOnClickListener {

            if (isOpen) {

                hawaiiFab.startAnimation(closeFabAnim)
                boliviaFab.startAnimation(closeFabAnim)
                istanbulFab.startAnimation(closeFabAnim)
                newYorkFab.startAnimation(closeFabAnim)

                isOpen = false


            } else {
                hawaiiFab.startAnimation(openFabAnim)
                boliviaFab.startAnimation(openFabAnim)
                istanbulFab.startAnimation(openFabAnim)
                newYorkFab.startAnimation(openFabAnim)

                isOpen = true

            }
        }

        newYorkFab.setOnClickListener {
            val intent = Intent(it.context, CityActivityNewYork::class.java)
            it.context.startActivity(intent)
        }
        istanbulFab.setOnClickListener {
            val intent = Intent(it.context, CityActivityIstanbul::class.java)
            it.context.startActivity(intent)
        }
        hawaiiFab.setOnClickListener {
            val intent = Intent(it.context, CityActivityHawaii::class.java)
            it.context.startActivity(intent)
        }
        boliviaFab.setOnClickListener {
            val intent = Intent(it.context, CityActivityBolivia::class.java)
            it.context.startActivity(intent)
        }
    }
}