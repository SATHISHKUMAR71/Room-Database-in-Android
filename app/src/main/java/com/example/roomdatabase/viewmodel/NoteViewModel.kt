package com.example.roomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.model.Note

import com.example.roomdatabase.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(private val application: Application, private val noteRepository: NoteRepository):AndroidViewModel(application) {

   fun addNote(note: Note) =
       viewModelScope.launch {
           noteRepository.insertNote(note)
       }

    fun removeNote(note: Note) =
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    fun updateNote(note: Note) =
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    fun getAllNote(note: Note) =
        viewModelScope.launch {
            noteRepository.getAllNotes()
        }
}