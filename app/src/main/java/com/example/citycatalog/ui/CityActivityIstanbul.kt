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
            16,
            "The Hagia Sophia Grand Mosque / Ayasofya-i Kebir Cami-i Şerifi, with its innovative architecture, rich history, religious significance and extraordinary characteristics has been fighting against time for centuries, is the largest Eastern Roman Church in Istanbul. Constructed three times in the same location, it is the world’s oldest and fastest-completed cathedral. With its breathtaking domes that look like hanging in the air, monolithic marble columns and unparalleled mosaics, is one of the wonders of world’s architecture history."
        )
        val card12 = TravelLocationModel(
            "Istanbul",
            "Grand Bazaar",
            "https://media.timeout.com/images/105265906/630/472/image.jpg",
            4.5f,
            17,
            "One of the largest and oldest covered bazaars in the world, the Grand Bazaar is 30,700 square meters with over 60 streets and alleys and 4,000 shops. The original historical core of the bazaar, İç Bedesten, was completed by Mehmet the Conqueror in 1461. A “bedesten” refers to an indoor arcade with shops and there are several areas within the bazaar referred to by this name. Over the years, the Grand Bazaar expanded from this core of two bedestens to become a sprawling roofed complex of thousands of shops, fringed by the tradesmen’s inns and workshops known as hans. According to the Ottoman traveler Evliya Çelebi’s Seyahatname, by the seventeenth century the Kapalı Çarşı (or the Çarşı-yı-Kebir as it was known at the time) had reached its present size, with over 4,000 shops and nearly 500 stalls known in Turkish as dolap (literally translated to “cupboard”)."
        )
        val card13 = TravelLocationModel(
            "Istanbul",
            "St. Antoine Church",
            "https://i.pinimg.com/originals/f9/bf/18/f9bf18bcd94b6f8c75b75df762a5e253.jpg",
            4.9f,
            18,
            "An imposing red brick building, it was originally built on this site in 1725, but was demolished in the early 20th century,in order to make way for a tramway. However the church was rebuilt by the architect, Giuliu Mongeri and completed in 1912, and stands as a fine example of the Italian neo-Gothic and Tuscan-Lombard styles."
        )
        val card14 = TravelLocationModel(
            "Istanbul",
            "Dolmabahce Palace",
            "https://toursce.com/wp-content/uploads/2018/08/Dolmabahce-palace-museum-1.jpg",
            4.4f,
            19,
            "Dolmabahce Palace built in 19 th century is one of the most glamorous palaces in the world. It was the administrative center of the late Ottoman Empire with the last of Ottoman Sultans was residing there. After the foundation of the Turkish Republic in Ankara, Mustafa Kemal Ataturk transferred all government functions to the youthful capital but on his visits to Istanbul Ataturk occupied only a small room at Dolmabahce Palace as his own."
        )
        val card15 = TravelLocationModel(
            "Istanbul",
            "Galata Tower",
            "https://uted.org/galeri/20197194238.jpg",
            4.6f,
            20,
            "The Galata Tower, Galata Kulesi in Turkish, is one of the highest and oldest towers of Istanbul. 63 meter (206 feet) high tower provides a panoramic view of the old town. It was built in the 14th century by the Genoese colony as part of the defense wall surrounding their district at Galata directly opposite ancient Constantinopolis. They called the tower as \"Christea Turris\", or \"Tower of Christ\"."
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