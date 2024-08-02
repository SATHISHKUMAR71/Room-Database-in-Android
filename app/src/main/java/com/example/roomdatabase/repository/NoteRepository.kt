package com.example.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabase.database.NoteDatabase
import com.example.roomdatabase.model.Note

class NoteRepository(private val db:NoteDatabase) {

    suspend fun insertNote(note:Note) = db.getNoteDao().insertNote(note)

    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    suspend fun getNoteById(noteId:Int) = db.getNoteDao().getNoteById(noteId)

    suspend fun getAllNotes(): LiveData<MutableList<Note>> = db.getNoteDao().getAllNotes()

    suspend fun getNoteByTitle(title:String):LiveData<MutableList<Note>> = db.getNoteDao().getNoteByTitle(title)

    suspend fun searchNote(searchValue:String):LiveData<MutableList<Note>> = db.getNoteDao().searchNote(searchValue)

}