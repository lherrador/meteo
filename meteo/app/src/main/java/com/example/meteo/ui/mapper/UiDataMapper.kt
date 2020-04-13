package com.example.meteo.ui.mapper

import com.example.meteo.model.local.Daily
import com.example.meteo.model.local.WeatherResponse
import com.example.meteo.ui.uidata.DailyUiData
import com.example.meteo.ui.uidata.DailyWeatherUiData
import java.text.DateFormat

class UiDataMapper {

	fun mapWeatherResponseTo(weatherResponse: WeatherResponse): DailyWeatherUiData {
		return DailyWeatherUiData(mapDailyUiData(weatherResponse.daily))
	}

	private fun mapDailyUiData(dailyList: List<Daily>): List<DailyUiData> {
		return dailyList.map {
			DailyUiData(DateFormat.getDateInstance()
					.format(it.datetime.toDate()), it.weather.first().description)
		}
	}
}