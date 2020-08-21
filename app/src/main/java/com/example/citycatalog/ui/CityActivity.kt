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
import com.example.citycatalog.model.MainDashboardModel
import com.example.citycatalog.model.TravelLocationModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.card_container_location.*
import kotlin.math.abs

class CityActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var adapter: PagerAdapter
    lateinit var compositePageTransformer: CompositePageTransformer
    lateinit var mocklist: List<TravelLocationModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        val currentCity = intent.extras?.get("currentItem") as MainDashboardModel


        viewPager = findViewById(R.id.locationsViewPager)
        val hawaiiFab: FloatingActionButton = findViewById(R.id.FloatingActionButtonHawaii)
        val istanbulFab: FloatingActionButton = findViewById(R.id.FloatingActionButtonTR)
        val boliviaFab: FloatingActionButton = findViewById(R.id.FloatingActionButtonBolivia)
        val newYorkFab: FloatingActionButton = findViewById(R.id.FloatingActionButtonABD)
        val mainFab: FloatingActionButton = findViewById(R.id.mainFab)
        val openFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val closeFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        var isOpen = false

        when (currentCity.cityId) {
            1 -> {
                mocklist = createMockData()
            }
            2 -> {
                mocklist = createMockDataHawaii()
            }
            3 -> {
                mocklist = createMockDataIstanbul()
            }
            4 -> {
                mocklist = createMockDataBolivia()
            }


        }

        viewPager.adapter = ViewPagerAdapterCities(mocklist) { data: TravelLocationModel ->
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
            val currentItem = mainDashboardCities()[0]
            val intent = Intent(it.context, CityActivity::class.java)
            intent.putExtra("currentItem", currentItem)
            it.context.startActivity(intent)
        }
        istanbulFab.setOnClickListener {
            val currentItem = mainDashboardCities()[2]
            val intent = Intent(it.context, CityActivity::class.java)
            intent.putExtra("currentItem", currentItem)
            it.context.startActivity(intent)
        }
        hawaiiFab.setOnClickListener {
            val currentItem = mainDashboardCities()[1]
            val intent = Intent(it.context, CityActivity::class.java)
            intent.putExtra("currentItem", currentItem)
            it.context.startActivity(intent)
        }
        boliviaFab.setOnClickListener {
            val currentItem = mainDashboardCities()[3]
            val intent = Intent(it.context, CityActivity::class.java)
            intent.putExtra("currentItem", currentItem)
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

    private fun createMockData(): List<TravelLocationModel> {
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
        return list
    }

    private fun createMockDataIstanbul(): List<TravelLocationModel> {
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

        return list
    }

    private fun createMockDataHawaii(): List<TravelLocationModel> {
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
            "https://i2.wp.com/thepointsguy.com/wp-content/uploads/2020/06/Diamond-Head-Crater.jpg?fit=2119%2C1414px&ssl=1",
            4.5f,
            5,
            "Diamond Head is part of the Ko’olau Range of volcanoes that began erupting below sea level over 2.6 million years ago. A single eruption around 300,000 years ago created the crater. The crater encompasses 350 acres. The crater is much larger than its rim as it was formed explosively. This type of formation is known as a tuff cone. Diamond Head is part of the Ko’olau Range of volcanoes that began erupting below sea level over 2.6 million years ago. A single eruption around 300,000 years ago created the crater. The crater encompasses 350 acres. The crater is much larger than its rim as it was formed explosively. This type of formation is known as a tuff cone. Diamond Head is part of the Ko’olau Range of volcanoes that began erupting below sea level over 2.6 million years ago. A single eruption around 300,000 years ago created the crater. The crater encompasses 350 acres. The crater is much larger than its rim as it was formed explosively. This type of formation is known as a tuff cone. Diamond Head is part of the Ko’olau Range of volcanoes that began erupting below sea level over 2.6 million years ago. A single eruption around 300,000 years ago created the crater. The crater encompasses 350 acres. The crater is much larger than its rim as it was formed explosively. This type of formation is known as a tuff cone. Diamond Head is part of the Ko’olau Range of volcanoes that began erupting below sea level over 2.6 million years ago. A single eruption around 300,000 years ago created the crater. The crater encompasses 350 acres. The crater is much larger than its rim as it was formed explosively. This type of formation is known as a tuff cone. "
        )
        list.add(card1)
        list.add(card2)
        list.add(card3)
        list.add(card4)
        list.add(card5)

        return list
    }

    private fun createMockDataBolivia(): List<TravelLocationModel> {
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

    private fun mainDashboardCities(): List<MainDashboardModel> {

        val list = ArrayList<MainDashboardModel>()

        val mainCard1 = MainDashboardModel(
            "New York",
            "https://images.unsplash.com/photo-1506598417715-e3c191368ac0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80",
            1
        )
        val mainCard2 = MainDashboardModel(
            "Hawaii",
            "https://images.unsplash.com/photo-1509233725247-49e657c54213?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=387&q=80",
            2
        )
        val mainCard3 = MainDashboardModel(
            "Istanbul",
            "https://images.unsplash.com/photo-1558180077-09f158c76707?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80",
            3
        )
        val mainCard4 = MainDashboardModel(
            "Bolivia",
            "https://images.unsplash.com/photo-1546514170-5782b9071927?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=376&q=80",
            4
        )

        list.add(mainCard1)
        list.add(mainCard2)
        list.add(mainCard3)
        list.add(mainCard4)
        return list
    }
}