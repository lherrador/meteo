package com.example.meteo.viewModel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.meteo.R
import com.example.meteo.api.WeatherApiClient
import com.example.meteo.domain.WeatherDomain
import com.example.meteo.repository.WeatherRemoteRepository
import com.example.meteo.repository.WeatherRepository
import com.example.meteo.viewModel.WeatherViewModel


class WeatherViewModelFactory(private val hostApplication: Application) :
		ViewModelProvider.NewInstanceFactory() {

	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
			val weatherDomain = WeatherDomain(WeatherRepository(WeatherRemoteRepository(
					WeatherApiClient(hostApplication.getString(R.string.base_url),
							hostApplication.getString(R.string.app_id)))))
			return WeatherViewModel(hostApplication, weatherDomain) as T
		}
		throw IllegalArgumentException("This factory handle only ManualEntryViewModel classes")
	}
}