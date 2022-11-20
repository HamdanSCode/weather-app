package com.example.testwithapi.network

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "http://api.weatherunlocked.com/api/forecast/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//override fun onResponse(call: Call<Days>, response: Response<Days>) {
//    /* This will print the response of the network call to the Logcat */
//    Log.v("Hamdan", response.body())
//}

interface WeatherApiService {
    @GET("us.95014?app_id=8e3e5386&app_key=4b63d7ffd6040e069e737980fdaefd1c")
    suspend fun getWeather(): WeatherData
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }

}