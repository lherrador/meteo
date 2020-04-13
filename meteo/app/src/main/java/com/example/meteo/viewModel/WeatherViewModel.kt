package com.example.meteo.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.meteo.R
import com.example.meteo.domain.IWeatherDomain
import com.example.meteo.ui.mapper.UiDataMapper
import com.example.meteo.ui.uidata.DailyWeatherUiData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(private val hostApplication: Application,
                       private val weatherDomain: IWeatherDomain) :
		AndroidViewModel(hostApplication) {

	private val compositeDisposable = CompositeDisposable()
	private val uiDataMapper = UiDataMapper()
	val weatherUIDatasource: BehaviorProcessor<DailyWeatherUiData> by lazy {
		BehaviorProcessor.create<DailyWeatherUiData>()
	}

	fun refresh() {
		compositeDisposable.add(
				weatherDomain.findNextDaysWeather(lat = hostApplication.getString(R.string.lat),
								lon = hostApplication.getString(R.string.lon),
								appId = hostApplication.getString(R.string.app_id),
								units = hostApplication.getString(R.string.units),
								numberOfDay = hostApplication.resources.getInteger(
										R.integer.number_of_day))
						.map {
							uiDataMapper.mapWeatherResponseTo(it)
						}
						.subscribeOn(Schedulers.io())
						.subscribe({
							weatherUIDatasource.onNext(it)
						}, {
							Log.e("TAG", it.message ?: "Error on api weather")
						}))
	}

	override fun onCleared() {
		compositeDisposable.dispose()
		super.onCleared()
	}
}