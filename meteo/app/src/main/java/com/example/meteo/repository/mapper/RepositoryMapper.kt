package com.example.meteo.repository.mapper

import com.example.meteo.model.api.ApiDaily
import com.example.meteo.model.api.ApiTemp
import com.example.meteo.model.api.ApiWeather
import com.example.meteo.model.api.ApiWeatherResponse
import com.example.meteo.model.local.Daily
import com.example.meteo.model.local.Temp
import com.example.meteo.model.local.Weather
import com.example.meteo.model.local.WeatherResponse
import org.joda.time.DateTime
import org.joda.time.DateTimeZone

class RepositoryMapper {

	companion object {
		const val CONVERTER_UNIX_TO_DATE = 1000
	}

	fun mapRemoteToLocal(apiWeatherResponse: ApiWeatherResponse,
	                     numberOfDay: Int): WeatherResponse {
		with(apiWeatherResponse) {
			return WeatherResponse(daily = maRemoteDailyListToLocal(daily, numberOfDay))
		}
	}

	private fun maRemoteDailyListToLocal(apiDailyList: List<ApiDaily>,
	                                     numberOfDay: Int): List<Daily> {

		val lastElement = if (apiDailyList.size >= numberOfDay) numberOfDay else apiDailyList.size

		return apiDailyList.subList(0, lastElement)
				.map {
					with(it) {
						maRemoteDailyToLocal(it)
					}
				}
	}

	private fun maRemoteDailyToLocal(apiDaily: ApiDaily): Daily {
		with(apiDaily) {
			return Daily(datetime = DateTime(dt * CONVERTER_UNIX_TO_DATE), sunrise = sunrise,
					sunset = sunset, temp = mapRemoteTempToLocal(temp), pressure = pressure,
					humidity = humidity, dew_point = dew_point, wind_speed = wind_speed,
					wind_deg = wind_deg, weather = mapRemoteWeatherToLocal(weather),
					clouds = clouds, uvi = uvi, visibility = visibility, wind_gust = wind_gust)
		}
	}

	private fun mapRemoteTempToLocal(apiTemp: ApiTemp): Temp {
		with(apiTemp) {
			return Temp(day = day, min = min, max = max, night = night, eve = eve, morn = morn)
		}
	}

	private fun mapRemoteWeatherToLocal(apiWeatherList: List<ApiWeather>): List<Weather> {
		return apiWeatherList.map {
			with(it) {
				Weather(main = main, description = description, icon = icon)
			}
		}

	}
}