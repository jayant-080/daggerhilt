package com.example.listadapter

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerhilt.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NoteActvity:AppCompatActivity(){


    @Inject
    lateinit var notesAdapter: NotesAdapter



    private val notesViewModel: NotesViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        notesAdapter = NotesAdapter(this)
        findViewById<RecyclerView>(R.id.rv_notes).adapter=notesAdapter

       notesViewModel.notess.observe(this, Observer {
            notesAdapter.submitList(it.toMutableList())

       })


        findViewById<Button>(R.id.btn_add_note).setOnClickListener {

            val newNote = Notes(id = System.currentTimeMillis().toInt(), note = Math.random().toString())
            notesViewModel.addNotes(newNote)


        }
    }




}