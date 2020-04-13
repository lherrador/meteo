package com.example.meteo.ui.recyclerviewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meteo.R
import com.example.meteo.ui.uidata.DailyUiData
import com.example.meteo.utils.bind

class DayWeatherRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
	private val date by bind<TextView>(R.id.date)
	private val description by bind<TextView>(R.id.description)

	fun bind(dailyUiData: DailyUiData) {
		date.text = dailyUiData.date
		description.text = dailyUiData.description
	}
}