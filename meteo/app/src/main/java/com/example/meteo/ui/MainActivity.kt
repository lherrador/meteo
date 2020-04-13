package com.example.meteo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.meteo.R
import com.example.meteo.ui.adapter.DayWeatherListAdapter
import com.example.meteo.utils.bind
import com.example.meteo.viewModel.WeatherViewModel
import com.example.meteo.viewModel.factory.WeatherViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

	private val recyclerView by bind<RecyclerView>(R.id.recycler_view)
	private val dayWeatherListAdapter = DayWeatherListAdapter()
	private val compositeDisposable = CompositeDisposable()
	private val weatherViewModel by lazy {
		ViewModelProvider(this, WeatherViewModelFactory(this.application)).get(
				WeatherViewModel::class.java)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		recyclerView.adapter = dayWeatherListAdapter

		compositeDisposable.add(
				weatherViewModel.weatherUIDatasource.observeOn(AndroidSchedulers.mainThread())
						.subscribeOn(Schedulers.io())
						.subscribe { uiData ->
							dayWeatherListAdapter.submitList(uiData.dailyUiDataList)
						})

		weatherViewModel.refresh()
	}
}
