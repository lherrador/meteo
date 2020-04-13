package com.example.meteo.model.local

import org.joda.time.DateTime

data class Daily(val datetime: DateTime, val sunrise: Int, val sunset: Int, val temp: Temp,
                 val pressure: Int, val humidity: Int, val dew_point: Double,
                 val wind_speed: Double, val wind_deg: Int, val weather: List<Weather>,
                 val clouds: Int, val uvi: Double, val visibility: Int, val wind_gust: Double)