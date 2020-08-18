package com.example.citycatalog.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.citycatalog.R
import com.example.citycatalog.adapter.RecyclerViewAdapterMainDashboard
import com.example.citycatalog.model.MainDashboardModel

class MainActivity : AppCompatActivity() {

    lateinit var recycView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.rcyDashboardCard)
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

        recycView = findViewById(R.id.rcyDashboardCard)
        recycView.adapter = RecyclerViewAdapterMainDashboard(list)
        recycView.layoutManager = GridLayoutManager(this, 2)


    }


}