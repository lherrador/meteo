package com.example.meteo.model.api

import com.google.gson.annotations.SerializedName

data class ApiDaily(@SerializedName("dt") val dt: Long, @SerializedName("sunrise") val sunrise: Int,
                    @SerializedName("sunset") val sunset: Int,
                    @SerializedName("temp") val temp: ApiTemp,
                    @SerializedName("pressure") val pressure: Int,
                    @SerializedName("humidity") val humidity: Int,
                    @SerializedName("dew_point") val dew_point: Double,
                    @SerializedName("wind_speed") val wind_speed: Double,
                    @SerializedName("wind_deg") val wind_deg: Int,
                    @SerializedName("weather") val weather: List<ApiWeather>,
                    @SerializedName("clouds") val clouds: Int,
                    @SerializedName("uvi") val uvi: Double,
                    @SerializedName("visibility") val visibility: Int,
                    @SerializedName("wind_gust") val wind_gust: Double)