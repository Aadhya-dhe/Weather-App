package com.practical.weatherappusingcoroutines.service


import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

class WeatherApiService {
    //https://api.openweathermap.org/data/2.5/weather?q=hema&APPID=b26931ff41bea97fcf6093340f59ede5
//    private val Base_Url = " https://api.openweathermap.org"
//    retrofit call in a class
//
//    private val api = Retrofit.Builder()
//        .baseUrl(Base_Url)
//
//        .addConverterFactory(GsonConverterFactory.create())
//       .addCallAdapterFactory(CoroutineCallAdapterFactory())
//
//       .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .build()
//        .create(WeatherApi::class.java)
//    //function to call the data from weather api
//
//  fun getdataservice(cityName: String): WeatherModel{
//        return api.getdata(cityName)
//    }
    companion object{
        private val Base_Url = " https://api.openweathermap.org"
        fun getdataApi():Retrofit= Retrofit.Builder()
            .baseUrl(Base_Url)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }

     }
