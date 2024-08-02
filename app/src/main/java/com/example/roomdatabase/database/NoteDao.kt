package com.example.roomdatabase.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.roomdatabase.model.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM NOTES ORDER BY createdAt DESC")
    suspend fun getAllNotes():LiveData<MutableList<Note>>

    @Query("SELECT * FROM NOTES WHERE id=:noteId")
    suspend fun getNoteById(noteId:Int)

    @Query("SELECT * FROM NOTES WHERE id=:title")
    suspend fun getNoteByTitle(title:String):LiveData<MutableList<Note>>

    @Query("SELECT * FROM NOTES WHERE title LIKE :searchValue or content LIKE :searchValue")
    suspend fun searchNote(searchValue:String):LiveData<MutableList<Note>>

}