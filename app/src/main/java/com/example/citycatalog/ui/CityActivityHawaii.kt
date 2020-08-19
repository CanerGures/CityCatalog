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


class CityActivityHawaii : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var adapter: PagerAdapter
    lateinit var compositePageTransformer: CompositePageTransformer
    private lateinit var background: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.do_not_move, R.anim.do_not_move)
        setContentView(R.layout.activity_city_hawaii)

        viewPager = findViewById(R.id.locationsViewPager)
        background = findViewById(R.id.backgroundHawaii)
        val hawaiiFab: FloatingActionButton = findViewById(R.id.hwFloatingActionButtonHawaii)
        val istanbulFab: FloatingActionButton = findViewById(R.id.hwFloatingActionButtonTR)
        val boliviaFab: FloatingActionButton = findViewById(R.id.hwFloatingActionButtonBolivia)
        val newYorkFab: FloatingActionButton = findViewById(R.id.hwFloatingActionButtonABD)
        val mainFab: FloatingActionButton = findViewById(R.id.mainFab)
        val openFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val closeFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        var isOpen = false

        val list = ArrayList<TravelLocationModel>()

        val card1 = TravelLocationModel(
            "Hawaii",
            "Na Pali Coast, Kauai",
            "https://images.unsplash.com/photo-1505852679233-d9fd70aff56d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            4.8f,
            1,
            "Nā Pali Coast State Park is touted as one of the most beautiful places on earth. Regal mountains and fluted peaks embellished with dramatic sea caves and valleys make it the epitome of paradise. Ancient Hawaiians once resided within the many valleys in this esteemed locale. Their communities thrived, obtaining sustenance from fishing or harvesting produce like taro. Kalalau Valley nurtured the largest Nā Pali Coast community and continues drawing people to its cathedral-like beauty."
        )
        val card2 = TravelLocationModel(
            "Hawaii",
            "Kihei",
            "https://images.unsplash.com/photo-1462400362591-9ca55235346a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1017&q=80",
            4.5f,
            2,
            "Arguably the most beautiful island in Hawaii, Kauai (a.k.a. the Garden Island) is a quiet, laid-back island with a gorgeous mix of arid canyons and lush coastline. It lacks some of the major development found on Oahu, Maui, or even the Big Island, and while there’s not much of a party scene, the opportunities for relaxing and exploring are unparalleled. One of the most popular activities is exploring the Na Pali Coast, a stretch of mystical coastline that can be accessed either by boat or by hiking 11 miles each way and camping. The other star attraction on the island is the mile-long Waimea Canyon, often called the “Grand Canyon of the Pacific” due to its impressive size."
        )
        val card3 = TravelLocationModel(
            "Hawaii",
            "Hanauma Bay Nature Preserve",
            "https://images.unsplash.com/photo-1585352141368-b7833cca7e39?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1934&q=80",
            4.9f,
            3,
            "Hanauma Bay Nature Preserve, one of the most spectacular natural resources in Hawaii, is reaping the benefits of over a decade of moves to re-establish its pristine marine ecosystem. Recognizing the damage done by years of neglect and abuse by allowing some three million visitors annually, the City and County of Honolulu in 1990 laid out a plan to restore Hanauma to a clean, healthy state by reducing the number of visitors, establishing an education program, and instituting supportive restrictions."
        )
        val card4 = TravelLocationModel(
            "Hawaii",
            "Haleakala National Park",
            "https://images.unsplash.com/photo-1469826834904-e92950ee5bf9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1031&q=80",
            4.4f,
            4,
            "Located on the island of Maui, Haleakalā National Park extends from the 10,023 foot (3055m) summit of Haleakalā down the southeast flank of the mountain to the Kīpahulu coast near Hana. These two sections of the park are not directly connected by road, but both can be reached from Kahului. There are no gas stations within the park. The last place to get gas in route to the Summit Area is in the town of Pukalani, and along the Hana Highway before Hana is in the town of is in the town of Paia."
        )
        val card5 = TravelLocationModel(
            "Hawaii",
            "Diamond Head, Oʻahu",
            "https://lh3.googleusercontent.com/proxy/G4GbinQti3CeMjkZZfvxg0Ek1DgOAmyzLPdCB1whxXhCRh8dLZA2Bm9oChYVOI2DvPPEvL1dfSJh11E8FhdU36Fx2g-82Y1aIcPLAVvxKkwFrIkFnolyJiFJg932oe_V1LEODKfuM-ryVns-QI2b",
            4.5f,
            5,
            "Diamond Head is part of the Ko’olau Range of volcanoes that began erupting below sea level over 2.6 million years ago. A single eruption around 300,000 years ago created the crater. The crater encompasses 350 acres. The crater is much larger than its rim as it was formed explosively. This type of formation is known as a tuff cone. "
        )
        list.add(card1)
        list.add(card2)
        list.add(card3)
        list.add(card4)
        list.add(card5)


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

            if(isOpen){

                hawaiiFab.startAnimation(closeFabAnim)
                boliviaFab.startAnimation(closeFabAnim)
                istanbulFab.startAnimation(closeFabAnim)
                newYorkFab.startAnimation(closeFabAnim)

                isOpen = false


            }else{
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


        /*if (savedInstanceState == null) {
            background.visibility = View.INVISIBLE
            val viewTreeObserver = background.viewTreeObserver
            if (viewTreeObserver.isAlive) {
                viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        circularRevealActivity()
                        background.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                })
            }
        }*/

    }


    /* private fun circularRevealActivity() {
         val cx = background.right - getDips(44)
         val cy = background.bottom - getDips(44)
         val finalRadius = Math.max(background.width, background.height).toFloat()
         val circularReveal: Animator = ViewAnimationUtils.createCircularReveal(
             background,
             cx,
             cy, 0f,
             finalRadius
         )
         circularReveal.setDuration(3000)
         background.visibility = View.VISIBLE
         circularReveal.start()
     }

     private fun getDips(dps: Int): Int {
         val resources = resources
         return TypedValue.applyDimension(
             TypedValue.COMPLEX_UNIT_DIP,
             dps.toFloat(),
             resources.displayMetrics
         ).toInt()
     }

     override fun onBackPressed() {
         if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
             val cx = background.width - getDips(44)
             val cy = background.bottom - getDips(44)

             val finalRadius = Math.max(background.width, background.height).toFloat()
             val circularReveal =
                 ViewAnimationUtils.createCircularReveal(background, cx, cy, finalRadius, 0f)

             circularReveal.addListener(object : Animator.AnimatorListener {
                 override fun onAnimationStart(animator: Animator) {}
                 override fun onAnimationEnd(animator: Animator) {
                     background.visibility = View.INVISIBLE
                     finish()
                 }

                 override fun onAnimationCancel(animator: Animator) {}
                 override fun onAnimationRepeat(animator: Animator) {}
             })
             circularReveal.duration = 3000
             circularReveal.start()
         }
         else{
             super.onBackPressed()
         }

     }*/
}