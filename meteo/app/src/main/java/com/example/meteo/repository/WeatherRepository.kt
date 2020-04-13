package com.example.meteo.repository

import com.example.meteo.model.local.WeatherResponse
import io.reactivex.Single

class WeatherRepository(private val weatherRemoteRepository: IWeatherRemoteRepository) :
		IWeatherRepository {
	override fun findNextDaysWeather(lat: String, lon: String, appId: String, units: String,
	                                 numberOfDay: Int): Single<WeatherResponse> {
		return weatherRemoteRepository.findNextDaysWeather(lat, lon, appId, units, numberOfDay)
	}
}

interface IWeatherRepository {
	fun findNextDaysWeather(lat: String, lon: String, appId: String, units: String,
	                        numberOfDay: Int): Single<WeatherResponse>
}