package com.example.livedata

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilt.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ActivityLiveData:AppCompatActivity(),OnItemRemove {

    private val viewModel by viewModels<VLiveDataViewModel>()
    private lateinit var messageAdapter:MessageListAdapter


    @Inject
    lateinit var repository: LiveRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        val lists = ArrayList<Messages>()

        messageAdapter = MessageListAdapter(this@ActivityLiveData,this@ActivityLiveData)
        findViewById<RecyclerView>(R.id.rv_messages).adapter = messageAdapter

        viewModel.data.observe(this, Observer {

        })


        var i = 0
        findViewById<Button>(R.id.btn_add).setOnClickListener {
            //viewModel.addMessage(Math.random().toString())

            lists.add(Messages(Math.random().toString(),i++))
            messageAdapter.submitList(lists)
            Log.d("mnmn",it.toString())
        }





    }



    override fun removeItem(position: Int) {
       viewModel.removeItem(position)


    }
}