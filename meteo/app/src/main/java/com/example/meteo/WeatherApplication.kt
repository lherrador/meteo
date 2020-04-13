package com.example.meteo

import android.app.Application
import com.example.meteo.api.WeatherApiClient
import com.example.meteo.domain.IWeatherDomain
import com.example.meteo.domain.WeatherDomain
import com.example.meteo.repository.WeatherRemoteRepository
import com.example.meteo.repository.WeatherRepository

class WeatherApplication : Application() {

	private val weatherDomain: IWeatherDomain by lazy {
		WeatherDomain(WeatherRepository(WeatherRemoteRepository(
				WeatherApiClient(this.getString(R.string.base_url),
						this.getString(R.string.app_id)))))
	}

	fun findWeatherDomain() = weatherDomain
}
