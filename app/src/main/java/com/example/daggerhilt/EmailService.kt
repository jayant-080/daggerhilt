package com.example.daggerhilt

import android.util.Log
import javax.inject.Inject

class EmailService @Inject constructor() {


    fun sendEmail(){
        Log.d("mnmn","Email Sent")
    }
}