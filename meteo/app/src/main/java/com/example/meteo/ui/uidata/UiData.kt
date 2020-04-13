package com.example.meteo.ui.uidata

data class DailyWeatherUiData(val dailyUiDataList: List<DailyUiData>)
data class DailyUiData(val date: String, val description: String)