package com.practical.weather.model

import com.practical.weatherappusingcoroutines.model.*

//data class is used hold and store .where it can reduces the boilerplate. it contains the tostring , hashcode
//val is not mutable .it is fixed

data class WeatherModel(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)