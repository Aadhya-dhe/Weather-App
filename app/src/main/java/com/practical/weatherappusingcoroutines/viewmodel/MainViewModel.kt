package com.practical.weatherappusingcoroutines.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practical.weather.model.WeatherModel
import com.practical.weatherappusingcoroutines.service.WeatherApi
import com.practical.weatherappusingcoroutines.service.WeatherApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val TAG ="MainViewModel"
class MainViewModel : ViewModel() {



    var weatherdata = MutableLiveData<WeatherModel>()
    val weathererror = MutableLiveData<Boolean>()
    val weatherloading = MutableLiveData<Boolean>()

    fun refreshData(cityName: String) {
        getDataFromAPI(cityName)
    }


   fun getDataFromAPI(cityName: String) {


       weatherloading.value = true

   // In the place of viewmodelscope , we can also try it Global scope..but it ends with after the application flow
      GlobalScope.launch(Dispatchers.Main) {
           val result = WeatherApiService.getdataApi().create(WeatherApi::class.java)
          // val response = result.getdata(cityName = cityName)
          try{
              val response = result.getdata(cityName = cityName)
              Log.d(TAG , "try strted")
              weatherdata.value = response
              weatherloading.value = false
              weathererror.value = false
          }
          catch (error:Exception){
              weatherloading.postValue(false)
              weathererror.postValue(true)
             // Toast.makeText(this@MainViewModel,"error",Toast.LENGTH_LONG).show()
              Log.d(TAG, "error occured")

          }
        finally {
            Log.d(TAG,"tryblock success")
        }



       }

//     val response = weatherApiService.getdataservice(cityName)
//       response.let {
//           weatherdata.value  = it
//           weatherloading.value=false
//       }




   }

}


