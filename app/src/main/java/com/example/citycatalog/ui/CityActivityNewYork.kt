package com.example.citycatalog.ui

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
import com.example.citycatalog.adapter.ViewPagerAdapterHawaii
import com.example.citycatalog.model.TravelLocationModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs

class CityActivityNewYork : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var adapter: PagerAdapter
    lateinit var compositePageTransformer: CompositePageTransformer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_new_york)



        viewPager = findViewById(R.id.locationsViewPager)
        val hawaiiFab: FloatingActionButton = findViewById(R.id.floatingActionButtonHawaii)
        val istanbulFab: FloatingActionButton = findViewById(R.id.floatingActionButtonTR)
        val boliviaFab: FloatingActionButton = findViewById(R.id.floatingActionButtonBolivia)
        val newYorkFab: FloatingActionButton = findViewById(R.id.floatingActionButtonABD)
        val mainFab: FloatingActionButton = findViewById(R.id.mainFab)
        val openFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val closeFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        var isOpen: Boolean = false

        val list = ArrayList<TravelLocationModel>()

        val card1 = TravelLocationModel(
            "New York",
            "Times Square",
            "https://imagesvc.meredithcorp.io/v3/mm/image?q=85&c=sc&poi=face&w=2000&h=1047&url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F9%2F2020%2F05%2F27%2Ftimes-square-billboards-going-dark-FT-BLOG0520.jpg",
            4.8f
        )
        val card2 = TravelLocationModel(
            "New York",
            "Empire State Building",
            "https://www.muzebiletleri.com/wp-content/uploads/2019/07/Empire-State-Binas%C4%B1-2.jpg",
            4.5f
        )
        val card3 = TravelLocationModel(
            "New York",
            "Brooklyn Bridge",
            "https://www.nuhotelbrooklyn.com/wp-content/uploads/2016/09/iStock_50554732_SMALL.jpg",
            4.9f
        )
        val card4 = TravelLocationModel(
            "New York",
            "Statue of Liberty",
            "https://www.mevzusanat.com/wp-content/uploads/2019/08/liberty-mevzusanat.jpg",
            4.4f
        )
        val card5 = TravelLocationModel(
            "New York",
            "Manhattan Bridge",
            "https://wp.zillowstatic.com/streeteasy/2/GettyImages-934879016-583e65.jpg",
            4.6f
        )
        list.add(card1)
        list.add(card2)
        list.add(card3)
        list.add(card4)
        list.add(card5)

        viewPager.adapter = ViewPagerAdapterHawaii(list)
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
    }
}