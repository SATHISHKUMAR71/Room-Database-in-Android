package com.example.roomdatabase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabase.database.NoteDatabase
import com.example.roomdatabase.repository.NoteRepository
import com.example.roomdatabase.viewmodel.NoteViewModel
import com.example.roomdatabase.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var noteViewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createViewModel()
    }

    private fun createViewModel(){
        val noteRepo = NoteRepository(NoteDatabase.getDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application,noteRepo)
        noteViewModel = ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}