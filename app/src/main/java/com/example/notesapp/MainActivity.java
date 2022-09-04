package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtNoteTitle;
    Button btnAddNote;
    RecyclerView recyclerView;
    DBHandler dbHandler;
    ArrayList<Notes> notes;
    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNoteTitle = findViewById(R.id.notesTitle);
        btnAddNote = findViewById(R.id.btnAddNote);
        recyclerView = findViewById(R.id.recyclerView);
        dbHandler = new DBHandler(this);
        notes = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        notes = dbHandler.readNotes();

        if ((notes.size() > 0)){
            notesAdapter = new NotesAdapter(MainActivity.this, notes);
            recyclerView.setAdapter(notesAdapter);
        }



        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
        });
    }
}