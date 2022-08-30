package com.example.flow
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FlowViewModel @Inject constructor(val flowRepository: FlowRepository) :ViewModel(){


    private val _data:MutableStateFlow<String> = MutableStateFlow("change")
    val data :StateFlow<String> = _data

    private val _list:MutableStateFlow<ArrayList<String>> = MutableStateFlow(arrayListOf())
    val list:StateFlow<ArrayList<String>> = _list


    suspend fun changeData(data:String){

       val datas =  flowRepository.chnageFLowData(data)
        datas.collect{
            _data.value = it
        }
    }

    suspend fun getData(){
         val data = flowRepository.getList()
        data.collect{
            _list.value = it as ArrayList
        }
    }


    suspend fun addData(data:String){
       flowRepository.addDataToList(data)
        getData()
    }











}