package com.example.meteo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.meteo.R
import com.example.meteo.ui.recyclerviewholder.DayWeatherRecyclerViewHolder
import com.example.meteo.ui.uidata.DailyUiData

class DayWeatherListAdapter :
		ListAdapter<DailyUiData, DayWeatherRecyclerViewHolder>(DiffCallback()) {
	override fun onCreateViewHolder(parent: ViewGroup,
	                                viewType: Int): DayWeatherRecyclerViewHolder {
		val view = LayoutInflater.from(parent.context)
				.inflate(R.layout.viewholder_weather_daily_list_item, parent, false)
		return DayWeatherRecyclerViewHolder(view)
	}

	override fun onBindViewHolder(dayWeatherRecyclerViewHolder: DayWeatherRecyclerViewHolder,
	                              position: Int) {
		dayWeatherRecyclerViewHolder.bind(currentList[position])
	}
}

class DiffCallback : DiffUtil.ItemCallback<DailyUiData>() {
	override fun areItemsTheSame(oldItem: DailyUiData, newItem: DailyUiData): Boolean {
		return oldItem.date == newItem.date
	}

	override fun areContentsTheSame(oldItem: DailyUiData, newItem: DailyUiData): Boolean {
		return oldItem.date == newItem.date && oldItem.description == newItem.description
	}

}