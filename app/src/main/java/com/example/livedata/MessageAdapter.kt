package com.example.livedata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilt.R

class MessageAdapter(val context:Context,val list:List<Messages>,val onItemRemove: OnItemRemove) :RecyclerView.Adapter<MessageAdapter.MessageViewHolder>(){

    class MessageViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_row_messages,parent,false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
       val list = list[position]
        holder.itemView.findViewById<TextView>(R.id.each_message).text = list.messages

        holder.itemView.setOnClickListener {
            onItemRemove.removeItem(position)
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }
}