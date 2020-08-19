package com.example.citycatalog.ui

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
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
import kotlinx.android.synthetic.main.card_container_location.*
import kotlin.math.abs

class CityActivityNewYork : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var adapter: PagerAdapter
    lateinit var compositePageTransformer: CompositePageTransformer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_new_york)



        viewPager = findViewById(R.id.locationsViewPager)
        val hawaiiFab: FloatingActionButton = findViewById(R.id.nyFloatingActionButtonHawaii)
        val istanbulFab: FloatingActionButton = findViewById(R.id.nyFloatingActionButtonTR)
        val boliviaFab: FloatingActionButton = findViewById(R.id.nyFloatingActionButtonBolivia)
        val newYorkFab: FloatingActionButton = findViewById(R.id.nyFloatingActionButtonABD)
        val mainFab: FloatingActionButton = findViewById(R.id.mainFab)
        val openFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val closeFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        var isOpen = false

        val list = ArrayList<TravelLocationModel>()

        val card1 = TravelLocationModel(
            "New York",
            "Times Square",
            "https://imagesvc.meredithcorp.io/v3/mm/image?q=85&c=sc&poi=face&w=2000&h=1047&url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F9%2F2020%2F05%2F27%2Ftimes-square-billboards-going-dark-FT-BLOG0520.jpg",
            4.8f,
            6,
            "Times Square is a major commercial intersection, tourist destination, entertainment center, and neighborhood in the Midtown Manhattan section of New York City, at the junction of Broadway and Seventh Avenue. Brightly lit by numerous billboards and advertisements, it stretches from West 42nd to West 47th Streets, and is sometimes referred to as \"the Crossroads of the World\", \"the Center of the Universe\", \"the heart of the Great White Way\", and \"the heart of the world\". One of the world's busiest pedestrian areas, it is also the hub of the Broadway Theater District and a major center of the world's entertainment industry. Times Square is one of the world's most visited tourist attractions, drawing an estimated 50 million visitors annually."
        )
        val card2 = TravelLocationModel(
            "New York",
            "Empire State Building",
            "https://www.muzebiletleri.com/wp-content/uploads/2019/07/Empire-State-Binas%C4%B1-2.jpg",
            4.5f,
            7,
            "The Empire State Building is a Art Deco skyscraper in Midtown Manhattan in New York City. It was designed by Shreve, Lamb & Harmon and built from 1930 to 1931. Its name is derived from \"Empire State\", the nickname of the state of New York. The building has a roof height of 1,250 feet (380 m) and stands a total of 1,454 feet (443.2 m) tall, including its antenna. The Empire State Building stood as the world's tallest building until the construction of the World Trade Center in 1970,after the attack the Empire State Building was again the city's tallest skyscraper until 2012. "
        )
        val card3 = TravelLocationModel(
            "New York",
            "Brooklyn Bridge",
            "https://www.nuhotelbrooklyn.com/wp-content/uploads/2016/09/iStock_50554732_SMALL.jpg",
            4.9f,
            8,
            "The Brooklyn Bridge is a hybrid cable-stayed/suspension bridge in New York City, spanning the East River between the boroughs of Manhattan and Brooklyn. Opened on May 24, 1883, the Brooklyn Bridge was the first fixed crossing across the East River. It was also the longest suspension bridge in the world at the time of its opening, with a main span of 1,595.5 feet (486.3 m) and a deck located 127 ft (38.7 m) above mean high water. The span was originally called the New York and Brooklyn Bridge or the East River Bridge but was officially renamed the Brooklyn Bridge in 1915."
        )
        val card4 = TravelLocationModel(
            "New York",
            "Statue of Liberty",
            "https://www.mevzusanat.com/wp-content/uploads/2019/08/liberty-mevzusanat.jpg",
            4.4f,
            9,
            "The Statue of Liberty (Liberty Enlightening the World; French: La Liberté éclairant le monde) is a colossal neoclassical sculpture on Liberty Island in New York Harbor within New York City, in the United States. The copper statue, a gift from the people of France to the people of the United States, was designed by French sculptor Frédéric Auguste Bartholdi and its metal framework was built by Gustave Eiffel. The statue was dedicated on October 28, 1886. The statue is a figure of Libertas, a robed Roman liberty goddess. She holds a torch above her head with her right hand, and in her left hand carries a tabula ansata inscribed JULY IV MDCCLXXVI (July 4, 1776 in Roman numerals), the date of the U.S. Declaration of Independence. A broken shackle and chain lie at her feet as she walks forward, commemorating the recent national abolition of slavery. After its dedication, the statue became an icon of freedom and of the United States, seen as a symbol of welcome to immigrants arriving by sea."
        )
        val card5 = TravelLocationModel(
            "New York",
            "Manhattan Bridge",
            "https://puzzlepalace.com.au/wp-content/uploads/2017/09/Manhattan-Bridge-New-York-1000-Piece-Educa-Puzzle.jpg",
            4.6f,
            10,
            "The Manhattan Bridge is a suspension bridge that crosses the East River in New York City, connecting Lower Manhattan at Canal Street with Downtown Brooklyn at the Flatbush Avenue Extension. The main span is 1,480 ft (451 m) long, with the suspension cables being 3,224 ft (983 m) long. The bridge's total length is 6,855 ft (2,089 m). It is one of four toll-free vehicular bridges connecting Manhattan Island to Long Island; the nearby Brooklyn Bridge is just slightly further downtown, while the Queensboro and Williamsburg bridges are to the north."
        )
        list.add(card1)
        list.add(card2)
        list.add(card3)
        list.add(card4)
        list.add(card5)

        viewPager.adapter = ViewPagerAdapterCities(list) { data: TravelLocationModel ->
            itemClicked(
                data
            )
        }
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

    private fun itemClicked(data: TravelLocationModel) {

        val intent = Intent(this, CityActivityDetail::class.java)
        val pair = Pair<View, String>(kbvLocation, "imageTransition")
        val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, pair)
        intent.putExtra("cityObject", data)
        startActivity(intent)
    }
}