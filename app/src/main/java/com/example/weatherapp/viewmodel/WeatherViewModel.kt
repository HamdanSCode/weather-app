package com.example.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.network.WeatherApi
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    //    //WORKS
    init {
        getWeatherData()
    }

    private fun getWeatherData() {
        viewModelScope.launch {
            try {
                val weatherResult = WeatherApi.retrofitService.getWeather()
                Log.v("Hamdan", "WEATHER RESULT: $weatherResult")
                _status.value = "Success: ${weatherResult.days.size} Mars photos retrieved"
            } catch (e: Exception) {
                Log.v("Hamdan", "failure, ${e.message}")
                _status.value = "Failure: ${e.message}"
            }

        }
    }
}