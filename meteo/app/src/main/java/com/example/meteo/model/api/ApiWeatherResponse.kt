package com.example.meteo.model.api

import com.google.gson.annotations.SerializedName

data class ApiWeatherResponse(@SerializedName("daily") val daily: List<ApiDaily>)