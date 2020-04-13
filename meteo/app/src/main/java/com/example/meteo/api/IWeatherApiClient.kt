package com.example.meteo.api

import androidx.annotation.WorkerThread
import com.example.meteo.model.api.ApiWeatherResponse
import io.reactivex.Single

interface IWeatherApiClient {

	@WorkerThread
	fun findNext16DaysWeather(lat: String, lon: String, appId: String,
	                          units: String): Single<ApiWeatherResponse>
}
