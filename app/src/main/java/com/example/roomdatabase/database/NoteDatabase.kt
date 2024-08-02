package com.example.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase:RoomDatabase() {

    abstract fun getNoteDao():NoteDao
    companion object{
        @Volatile
        private var INSTANCE:NoteDatabase? = null
        fun getDatabase(context: Context):NoteDatabase{
            return INSTANCE ?: synchronized(Any()){
                 INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "notes_app"
                 ).build()
                INSTANCE!!
            }
        }
    }
}