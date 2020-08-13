package com.example.citycatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.citycatalog.R
import com.example.citycatalog.model.Model
import kotlinx.android.synthetic.main.carditem.view.*

class ViewPagerAdapter(
    private val features: ArrayList<Model>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.image
        val titleView: TextView = itemView.title
        val descView: TextView = itemView.desc
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.carditem, parent, false)
        return ViewPagerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return features.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentItem = features[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.titleView.text = currentItem.title
        holder.descView.text = currentItem.desc
    }
}
