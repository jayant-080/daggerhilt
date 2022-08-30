package com.example.listadapter

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
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotesAdapter @Inject constructor(@ApplicationContext val  context:Context):ListAdapter<Notes,NotesAdapter.NotesViewHolder>(diff) {

    class NotesViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.each_row_note,parent,false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
       val item = getItem(position)
        holder.itemView.findViewById<TextView>(R.id.each_row_note).text = item.note
        Log.d("mnmn","bind called")

        holder.itemView.setOnClickListener {

            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            Log.d("mnmn","adapter pos :"+position)
        }

    }


    object diff :DiffUtil.ItemCallback<Notes>() {
        override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
           return newItem.id == oldItem.id
        }

        override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return newItem == oldItem
        }
    }
}