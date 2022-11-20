package com.example.weatherapp.network

import com.squareup.moshi.Json

data class WeatherData(
    @Json(name = "Days")
    val days: List<Day>
)

data class Day(
    @Json(name = "date")
    val date: String,
    @Json(name = "temp_max_f")
    val highTemp: Double,
    @Json(name = "temp_min_f")
    val lowTemp: Double,
    @Json(name = "precip_total_in")
    val precipitation: Double,
    @Json(name = "rain_total_in")
    val rain: Double,
    @Json(name = "snow_total_in")
    val snow: Double,
    @Json(name = "humid_min_pct")
    val humidity: Double,
    @Json(name="windspd_max_mph")
    val windSpeed: Double,
)