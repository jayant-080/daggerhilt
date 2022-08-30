package com.example.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AViewModel @Inject constructor():ViewModel(){

    var v_email:String= ""
    var v_password:String =""



    fun validateData(email:String,password:String):String{
        if(email == "" || password ==""){
             return  "all fields are required"
        }else{
            v_email =email
            v_password = password
        }

        return "registration done"

    }

}