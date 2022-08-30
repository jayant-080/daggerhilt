package com.example.listadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(val noteRepo: NoteRepo):ViewModel() {

    var notess :LiveData<MutableList<Notes>> = noteRepo.notes



    fun addNotes(notes: Notes){
        noteRepo.addNotes(notes)

    }

    fun removeNote(pos:Int){
        noteRepo.removeNote(pos)
    }





}