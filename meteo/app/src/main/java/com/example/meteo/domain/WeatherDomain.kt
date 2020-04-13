package com.example.meteo.domain

import com.example.meteo.model.local.WeatherResponse
import com.example.meteo.repository.IWeatherRepository
import io.reactivex.Single

class WeatherDomain(private val weatherRepository: IWeatherRepository) : IWeatherDomain {
	override fun findNextDaysWeather(lat: String, lon: String, appId: String, units: String,
	                                 numberOfDay: Int): Single<WeatherResponse> {
		return weatherRepository.findNextDaysWeather(lat, lon, appId, units, numberOfDay)
	}
}

interface IWeatherDomain {
	fun findNextDaysWeather(lat: String, lon: String, appId: String, units: String,
	                        numberOfDay: Int): Single<WeatherResponse>
}