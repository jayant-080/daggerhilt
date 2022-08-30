package com.example.livedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class LiveRepository @Inject constructor() {


    private val data:MutableLiveData<ArrayList<Messages>> = MutableLiveData(arrayListOf())
    val _data:LiveData<ArrayList<Messages>> = data
    val list = ArrayList<Messages>()

    init {
//        for (i in 1..4){
//            list.add(Messages(Math.random().toString()))
//            data.postValue(list)
//        }


    }




    fun removeItem(pos:Int){
        list.removeAt(pos)
    }

    fun addData(messages: String){

        list.add(Messages(messages,1))
        data.postValue(list)
        Log.d("mnmn",list.size.toString())
    }




}