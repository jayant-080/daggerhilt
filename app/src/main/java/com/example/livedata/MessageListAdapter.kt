package com.example.livedata

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilt.R

class MessageListAdapter(val context:Context, val onItemRemove: OnItemRemove) :
    ListAdapter<Messages, MessageListAdapter.MessageViewHolder>(Diff()){

    class MessageViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_row_messages,parent,false)
        return MessageViewHolder(view)


    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.findViewById<TextView>(R.id.each_message).text = item.messages
        Toast.makeText(context, item.toString(), Toast.LENGTH_SHORT).show()
        holder.itemView.setOnClickListener {
            onItemRemove.removeItem(position)
        }
    }

    class Diff : DiffUtil.ItemCallback<Messages>(){
        override fun areItemsTheSame(oldItem: Messages, newItem: Messages): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Messages, newItem: Messages): Boolean {
           return oldItem == newItem
        }

    }


}