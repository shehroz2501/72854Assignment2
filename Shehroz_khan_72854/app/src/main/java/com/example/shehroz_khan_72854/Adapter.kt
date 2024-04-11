package com.example.shehroz_khan_72854

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(
    private val movieDataList: MutableList<MovieData>,
    private val clickListener: ClickListener
): RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(holder.preview.context)
            .load(movieDataList[position].image)
            .into(holder.preview)


        holder.title.text = movieDataList[position].name
        holder.cast.text = movieDataList[position].starring.toString()
        holder.timeLeft.text = "${movieDataList[position].runnning_time_mins / 60}hrs ${movieDataList[position].runnning_time_mins % 60}mins"

        if (movieDataList[position].seats_selected > 0) {
            holder.seatsLeft.text = "${movieDataList[position].seats_selected} seats selected"
            holder.seatsLeft.setTextColor(Color.GREEN)
            holder.icon.imageTintList = null
            holder.icon.imageTintList = ColorStateList.valueOf(Color.GREEN)
        } else {
            holder.seatsLeft.text = "${movieDataList[position].seats_remaining} seats remaining"
            holder.seatsLeft.setTextColor(Color.WHITE)
            holder.icon.imageTintList = null
            holder.icon.imageTintList = ColorStateList.valueOf(Color.WHITE)
        }

        if (movieDataList[position].seats_remaining < 3) {
            holder.fillingFastBadge.visibility = View.VISIBLE

            if (movieDataList[position].seats_remaining == 0)
                holder.fillingFastBadge.text = "Sold Out"
        } else {
            holder.fillingFastBadge.visibility = View.GONE
        }

        when (movieDataList[position].certification) {
            "PG" -> holder.certification.setImageResource(R.drawable.certificate_pg)
            "16" -> holder.certification.setImageResource(R.drawable.certificate_16)
            "15A" -> holder.certification.setImageResource(R.drawable.certificate_15a)
        }
    }

    override fun getItemCount(): Int {
        return movieDataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val preview: ImageView = itemView.findViewById(R.id.preview)
        val title: TextView = itemView.findViewById(R.id.title)
        val cast: TextView = itemView.findViewById(R.id.cast)
        val timeLeft: TextView = itemView.findViewById(R.id.time_left)
        val seatsLeft: TextView = itemView.findViewById(R.id.seats_left)
        val icon: ImageView = itemView.findViewById(R.id.icon)
        val certification: ImageView = itemView.findViewById(R.id.certification)
        val fillingFastBadge: TextView = itemView.findViewById(R.id.filling_fast_badge)

        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }

    interface ClickListener {
        fun onItemClick(position: Int)
    }
}