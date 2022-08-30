package com.example.listadapter


import javax.inject.Inject

class RemoveNoteImple @Inject constructor(val noteRepo: NoteRepo):OnRemoveNote {

     override fun removeNote(pos:Int){
         noteRepo.removeNote(pos)
     }



}


