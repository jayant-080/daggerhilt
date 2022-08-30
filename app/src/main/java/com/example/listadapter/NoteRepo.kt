package com.example.listadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class NoteRepo @Inject constructor() {


    private val _notes :MutableLiveData<MutableList<Notes>> = MutableLiveData()
    val notes:LiveData<MutableList<Notes>> = _notes

    private val notelist:MutableList<Notes> = mutableListOf()

   fun addNotes(notes: Notes){
       notelist.add(notes)
       _notes.postValue(notelist)

   }

    fun removeNote(pos:Int){
        notelist.removeAt(pos)
        _notes.postValue(notelist)
    }


}