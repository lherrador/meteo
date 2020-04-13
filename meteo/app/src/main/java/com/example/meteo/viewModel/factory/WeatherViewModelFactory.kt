package com.example.meteo.viewModel.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.meteo.WeatherApplication
import com.example.meteo.viewModel.WeatherViewModel


class WeatherViewModelFactory(private val hostApplication: Application) :
		ViewModelProvider.NewInstanceFactory() {

	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
			val weatherDomain = (hostApplication as WeatherApplication).findWeatherDomain()
			return WeatherViewModel(hostApplication, weatherDomain) as T
		}
		throw IllegalArgumentException("This factory handle only ManualEntryViewModel classes")
	}
}