package com.example.daggerhilt

import android.util.Log
import javax.inject.Inject

class UserRegistrationService @Inject constructor(){

    fun saveUserToMongo(){
        Log.d("mnmn","message saved to mongodb")
    }

    fun saveToLocal(){
        Log.d("mnmn","saved to room db")
    }



}