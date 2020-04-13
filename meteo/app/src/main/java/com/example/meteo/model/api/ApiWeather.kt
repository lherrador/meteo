package com.example.meteo.model.api

import com.google.gson.annotations.SerializedName

data class ApiWeather(@SerializedName("main") val main: String,
                      @SerializedName("description") val description: String,
                      @SerializedName("icon") val icon: String)