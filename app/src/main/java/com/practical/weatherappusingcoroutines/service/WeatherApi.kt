package com.practical.weatherappusingcoroutines.service

import com.practical.weather.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.openweathermap.org/data/2.5/weather?q=hema&APPID=b26931ff41bea97fcf6093340f59ede5
interface WeatherApi {
    //get query is use to get the api call
    @GET("data/2.5/weather?&units=metric&APPID=b26931ff41bea97fcf6093340f59ede5")
  suspend fun getdata(
        @Query("q")cityName: String
    ): WeatherModel

}




