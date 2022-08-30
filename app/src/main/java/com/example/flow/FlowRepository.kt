package com.example.flow


import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FlowRepository @Inject constructor() {

    val datfromapi = ArrayList<String>()
    init {
      for(i in 1..10){
          datfromapi.add(Math.random().toString())
      }

    }
  suspend fun chnageFLowData(data:String) = flow<String> {

      emit(data)

  }

  suspend fun getList() = flow<List<String>> {
      emit(datfromapi)
  }

  suspend fun addDataToList(data:String) = flow<String> {
      datfromapi.add(data)
      Log.d("mnmn",datfromapi.toString())
      emit("added")
  }.flowOn(Dispatchers.Main)






}