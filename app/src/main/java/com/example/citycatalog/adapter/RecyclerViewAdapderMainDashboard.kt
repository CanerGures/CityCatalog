package com.example.citycatalog.adapter

import android.animation.AnimatorInflater
import android.animation.StateListAnimator
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.citycatalog.R
import com.example.citycatalog.model.MainDashboardModel
import com.example.citycatalog.ui.CityActivityBolivia
import com.example.citycatalog.ui.CityActivityHawaii
import com.example.citycatalog.ui.CityActivityIstanbul
import com.example.citycatalog.ui.CityActivityNewYork
import kotlinx.android.synthetic.main.main_dashboard_cards.view.*

class RecyclerViewAdapterMainDashboard(
    private val features: List<MainDashboardModel>
) : RecyclerView.Adapter<RecyclerViewAdapterMainDashboard.DashboardViewHolder>() {
    inner class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageUrlMain: ImageView = itemView.imageCity
        val textTitle: TextView = itemView.textTitleCity

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_dashboard_cards, parent, false)
        return DashboardViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return features.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val currentItem = features[position]
        holder.textTitle.text = currentItem.cityMain
        Glide.with(holder.itemView.context)
            .load(currentItem.imageUrlMain)
            .fitCenter()
            .into(holder.imageUrlMain)

        holder.itemView.setOnClickListener {


            when (currentItem.cityId) {
                1 -> {
                    val stateListAnimator: StateListAnimator =
                        AnimatorInflater.loadStateListAnimator(
                            it.context,
                            R.animator.elevation_on_touch
                        )
                    holder.itemView.stateListAnimator = stateListAnimator
                    val intent = Intent(it.context, CityActivityNewYork::class.java)
                    it.context.startActivity(intent)

                }
                2 -> {
                    val stateListAnimator: StateListAnimator =
                        AnimatorInflater.loadStateListAnimator(
                            it.context,
                            R.animator.elevation_on_touch
                        )
                    holder.itemView.stateListAnimator = stateListAnimator
                    val intent = Intent(it.context, CityActivityHawaii::class.java)
                    it.context.startActivity(intent)

                }
                3 -> {
                    val stateListAnimator: StateListAnimator =
                        AnimatorInflater.loadStateListAnimator(
                            it.context,
                            R.animator.elevation_on_touch
                        )
                    holder.itemView.stateListAnimator = stateListAnimator
                    val intent = Intent(it.context, CityActivityIstanbul::class.java)
                    it.context.startActivity(intent)


                }
                4 -> {
                    val stateListAnimator: StateListAnimator =
                        AnimatorInflater.loadStateListAnimator(
                            it.context,
                            R.animator.elevation_on_touch
                        )
                    holder.itemView.stateListAnimator = stateListAnimator
                    val intent = Intent(it.context, CityActivityBolivia::class.java)
                    it.context.startActivity(intent)

                }


            }


        }


    }
}