package com.example.meteo.repository

import com.example.meteo.api.IWeatherApiClient
import com.example.meteo.model.local.WeatherResponse
import com.example.meteo.repository.mapper.RepositoryMapper
import io.reactivex.Single

class WeatherRemoteRepository(private val weatherApiClient: IWeatherApiClient) :
		IWeatherRemoteRepository {

	private val repositoryMapper = RepositoryMapper()

	override fun findNextDaysWeather(lat: String, lon: String, appId: String, units: String,
	                                 numberOfDay: Int): Single<WeatherResponse> {
		return weatherApiClient.findNext16DaysWeather(lat, lon, appId, units)
				.map {
					repositoryMapper.mapRemoteToLocal(it, numberOfDay)
				}
	}
}

interface IWeatherRemoteRepository {
	fun findNextDaysWeather(lat: String, lon: String, appId: String, units: String,
	                        numberOfDay: Int): Single<WeatherResponse>
}