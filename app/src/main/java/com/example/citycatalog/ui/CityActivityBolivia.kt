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


        val mockData = createMockData()
        viewPager.adapter = ViewPagerAdapterCities(mockData) { data: TravelLocationModel ->
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

    private fun createMockData(): List<TravelLocationModel> {
        val list = ArrayList<TravelLocationModel>()

        val card11 = TravelLocationModel(
            "Bolivia",
            "Salar de Uyuni",
            "https://daily.jstor.org/wp-content/uploads/2015/08/Solar_de_Uyuni_1050x700.jpg",
            4.8f,
            11,
            "Salar de Uyuni (or Salar de Tunupa) is the world's largest salt flat, or playa, at over 10,000 square kilometres (3,900 sq mi) in area. It is in the Daniel Campos Province in Potosí in southwest Bolivia, near the crest of the Andes at an elevation of 3,656 meters (11,995 ft) above sea level. The Salar was formed as a result of transformations between several prehistoric lakes. It is covered by a few meters of salt crust, which has an extraordinary flatness with the average elevation variations within one meter over the entire area of the Salar. The crust serves as a source of salt and covers a pool of brine, which is exceptionally rich in lithium. The large area, clear skies, and exceptional flatness of the surface make the Salar ideal for calibrating the altimeters of Earth observation satellites"
        )
        val card12 = TravelLocationModel(
            "Bolivia",
            "Sajama National Park",
            "https://img.locationscout.net/images/2019-04/sajama-national-park-bolivia_l.jpeg",
            4.5f,
            12,
            "Sajama National Park is a national park located in the Oruro Department, Bolivia. It borders Lauca National Park in Chile. The park is home to indigenous people, known as the Aymara, whose influential ancient culture can be seen in various aspects throughout the park. The park contains unique cultural artifacts and ecological wonders, making it an exemplary location for ecotourism. Many different indigenous plants and animals are exclusive to this area; therefore, its continued conservation is of great ecological importance. Management of the park operates under a co-administrative approach, with local people and park conservationists engaging in a constant dialogue regarding park upkeep and policy."
        )
        val card13 = TravelLocationModel(
            "Bolivia",
            "La Glorieta Castle, Sucre",
            "https://media-cdn.tripadvisor.com/media/photo-s/0b/48/2c/fb/torres.jpg",
            4.9f,
            13,
            "See the eclectic European-inspired architecture of La Glorieta Castle, the former home of Don Francisco de Argandona and his wife Clotilde. The couple returned from a tour of the Continent and commissioned a castle that combines elements of the designs they saw there. Architect Antonio Camponovo mixed Gothic, Baroque, Rococo, Byzantine, and Manierista in this 19th-century structure. The reddish-pinkish hue of the building lends the place a fairy-tale feel. Note that the decorative interiors are fairly empty of furniture, so you'll need to use your imagination. Stroll the open (if unkempt) grounds, and climb one of the castle's towers for views of the nearby military base."
        )
        val card14 = TravelLocationModel(
            "Bolivia",
            "Death Road, La Paz",
            "https://cms.hostelworld.com/hwblog/wp-content/uploads/sites/2/2019/10/best-places-to-visit-in-Bolivia-Matthew-Straubmuller-Death-Road.jpg",
            4.4f,
            14,
            "The Yungas Road is a cycle route about 60 km long which links the city of La Paz and the Yungas region of Bolivia. It draws about 25,000 tourists per year and is a major La Paz tourist attraction.[2] Many tour operators cater to downhill mountain biking, providing information, guides, transport and equipment. At least 18 cyclists have died on the road since 1998. The tourist route is a 64 km long road with 3500 metres of descent. The route includes the Cotapata-Santa Bárbara section. It replaced the old road, built in 1930. It was considered dangerous because of its steep slopes, narrow single track, lack of guardrails, rain, and fog, and was nicknamed the \"Road of Death\"."
        )
        val card15 = TravelLocationModel(
            "Bolivia",
            "Mount Illimani, La Paz",
            "https://cms.hostelworld.com/hwblog/wp-content/uploads/sites/2/2019/10/best-places-to-visit-in-Bolivia-@akhamani-llimani.jpg",
            4.6f,
            15,
            "Illimani (Aymara) is the highest mountain in the Cordillera Real of western Bolivia. It lies near the cities of El Alto and La Paz at the eastern edge of the Altiplano. It is the second highest peak in Bolivia, after Nevado Sajama, and the eighteenth highest peak in South America. The snow line lies at about 4,570 metres (15,000 ft) above sea level, and glaciers are found on the northern face at 4,983 m (16,350 ft). The mountain has four main peaks; the highest is the south summit, Nevado Illimani, which is a popular ascent for mountain climbers. Geologically, Illimani is composed primarily of granodiorite, intruded during the Cenozoic era into the sedimentary rock, which forms the bulk of the Cordillera Real."
        )
        list.add(card11)
        list.add(card12)
        list.add(card13)
        list.add(card14)
        list.add(card15)
        return list

    }

    private fun itemClicked(data: TravelLocationModel) {

        val intent = Intent(this, CityActivityDetail::class.java)
        val pair = Pair<View, String>(kbvLocation, "imageTransition")
        val options: ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this, pair)
        intent.putExtra("cityObject", data)
        startActivity(intent)
    }
}