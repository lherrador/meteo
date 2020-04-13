package com.example.meteo.api

import com.example.meteo.model.api.ApiWeatherResponse
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

class WeatherApiClient(baseUrl: String, private val appId: String) : IWeatherApiClient {

	private val weatherApi: WeatherApi

	init {
		val logging = HttpLoggingInterceptor()
		logging.level = (HttpLoggingInterceptor.Level.BASIC)
		val client = OkHttpClient.Builder()
				.addInterceptor(logging)
				.build()
		val retrofit = Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create(Gson()))
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(client)
				.build()
		weatherApi = retrofit.create(WeatherApi::class.java)
	}

	override fun findNext16DaysWeather(lat: String, lon: String, appId: String,
	                                   units: String): Single<ApiWeatherResponse> {
		return weatherApi.findWeatherByOneCall(lat, lon, appId, units)
	}
}
