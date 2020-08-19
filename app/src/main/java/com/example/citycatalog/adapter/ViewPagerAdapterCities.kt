package com.example.citycatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.citycatalog.R
import com.example.citycatalog.model.TravelLocationModel
import kotlinx.android.synthetic.main.card_container_location.view.*

class ViewPagerAdapterCities(
    private val features: List<TravelLocationModel>,
    val callBack: (TravelLocationModel) -> Unit
) : RecyclerView.Adapter<ViewPagerAdapterCities.ViewPagerViewHolder>() {
    class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /*val kbvLocation: ImageView = itemView.kbvLocation
        val textTitle: TextView = itemView.textTitle
        val textLocation: TextView = itemView.textLocation
        val textStarRating: TextView = itemView.textStarRating*/

        fun bind(data: TravelLocationModel, callback: (TravelLocationModel) -> Unit) {
            val kbvLocation: ImageView = itemView.kbvLocation
            val textTitle: TextView = itemView.textTitle
            val textLocation: TextView = itemView.textLocation
            val textStarRating: TextView = itemView.textStarRating


            textTitle.text = data.title
            textLocation.text = data.location
            textStarRating.text = data.starRating.toString()

            Glide.with(itemView.context)
                .load(data.imageUrl)
                .fitCenter()
                .into(kbvLocation)

            itemView.setOnClickListener { callback(data) }

        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_container_location, parent, false)
        return ViewPagerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return features.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        /*val currentItem = features[position]
        holder.textTitle.text = currentItem.title
        holder.textLocation.text = currentItem.location
        holder.textStarRating.text = currentItem.starRating.toString()

        Glide.with(holder.itemView.context)
            .load(currentItem.imageUrl)
            .fitCenter()
            .into(holder.kbvLocation)

        holder.itemView.setOnClickListener {


            val intent = Intent(it.context, CityActivityDetail::class.java)
            val pair = Pair<View,String>(holder.kbvLocation, "imageTransition")
            val options :ActivityOptions = ActivityOptions.makeSceneTransitionAnimation(, pair)
            intent.putExtra("cityObject", currentItem as Serializable)
            it.context.startActivity(intent)

        }*/

        holder.bind(features[position], callBack)
    }

}