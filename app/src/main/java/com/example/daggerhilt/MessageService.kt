package com.example.daggerhilt

import android.util.Log
import javax.inject.Inject

class MessageService @Inject constructor(){

  fun sendMessage(){
    Log.d("mnmn","Message Sent")
  }
}

