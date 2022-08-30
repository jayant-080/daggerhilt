package com.example.flow

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerhilt.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class FlowActivity:AppCompatActivity() {

    private val flowViewModel:FlowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)
         getData()
        observer()
        findViewById<TextView>(R.id.flowsubmit).setOnClickListener {
            addData(Math.random().toString())
        }
    }

    private fun observer() {
        CoroutineScope(Dispatchers.Main).launch{
            flowViewModel.list.collect{
              findViewById<TextView>(R.id.flowtext).text = it.toString()
                Log.d("mnmn activtiy",it.toString())
            }
        }
    }

    private fun getData() {

        CoroutineScope(Dispatchers.Main).launch{
            flowViewModel.getData()
        }


    }

    private fun addData(data:String){
        CoroutineScope(Dispatchers.Main).launch {
            flowViewModel.addData(data)
        }

    }


}