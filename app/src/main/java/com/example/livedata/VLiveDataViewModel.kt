package com.example.livedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class VLiveDataViewModel @Inject constructor(val liveRepository: LiveRepository):ViewModel(){


    val data :LiveData<ArrayList<Messages>> = liveRepository._data




    fun removeItem(pos:Int){
        liveRepository.removeItem(pos)
    }

    fun addMessage(messages: String){

        liveRepository.addData(messages)
    }






}