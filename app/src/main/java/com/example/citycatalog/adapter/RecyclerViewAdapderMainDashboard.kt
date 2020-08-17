package com.example.citycatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.citycatalog.R
import com.example.citycatalog.model.MainDashboardModel
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

    }
}