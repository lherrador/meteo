package com.example.meteo.api

import com.example.meteo.model.api.ApiWeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface WeatherApi {
	companion object {
		const val LAT = "lat"
		const val LON = "lon"
		const val APP_ID = "APPID"
		const val UNITS = "units"
	}

	@GET("onecall")
	fun findWeatherByOneCall(@Query(LAT) lat: String, @Query(LON) lon: String,
	                         @Query(APP_ID) appId: String,
	                         @Query(UNITS) units: String): Single<ApiWeatherResponse>
}
