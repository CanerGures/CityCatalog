package com.example.citycatalog.ui

import android.animation.ArgbEvaluator
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
import com.example.citycatalog.model.Model
import com.example.citycatalog.model.TravelLocationModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs

class CityActivityIstanbul : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var adapter: PagerAdapter
    lateinit var feature: Model
    lateinit var rgbevaluator: ArgbEvaluator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_istanbul)

        viewPager = findViewById(R.id.locationsViewPager)
        val hawaiiFab: FloatingActionButton = findViewById(R.id.trFloatingActionButtonHawaii)
        val istanbulFab: FloatingActionButton = findViewById(R.id.trFloatingActionButtonTR)
        val boliviaFab: FloatingActionButton = findViewById(R.id.trFloatingActionButtonBolivia)
        val newYorkFab: FloatingActionButton = findViewById(R.id.trFloatingActionButtonABD)
        val mainFab: FloatingActionButton = findViewById(R.id.mainFab)
        val openFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val closeFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        var isOpen = false

        val list = ArrayList<TravelLocationModel>()

        val card11 = TravelLocationModel(
            "Istanbul",
            "Hagia Sophia",
            "https://i.hurimg.com/i/hdn/75/0x0/5c0d246dc03c0e15a49c546a.jpg",
            4.8f,
            16
        )
        val card12 = TravelLocationModel(
            "Istanbul",
            "Grand Bazaar",
            "https://media.timeout.com/images/105265906/630/472/image.jpg",
            4.5f,
            17
        )
        val card13 = TravelLocationModel(
            "Istanbul",
            "St. Antoine Church",
            "https://i.pinimg.com/originals/f9/bf/18/f9bf18bcd94b6f8c75b75df762a5e253.jpg",
            4.9f,
            18
        )
        val card14 = TravelLocationModel(
            "Istanbul",
            "Dolmabahce Palace",
            "https://toursce.com/wp-content/uploads/2018/08/Dolmabahce-palace-museum-1.jpg",
            4.4f,
            19
        )
        val card15 = TravelLocationModel(
            "Istanbul",
            "Galata Tower",
            "https://uted.org/galeri/20197194238.jpg",
            4.6f,
            20
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