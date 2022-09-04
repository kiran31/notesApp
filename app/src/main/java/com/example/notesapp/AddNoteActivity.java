package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    EditText edtTitle, edtDesc;
    Button btnAddNewNote;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        edtTitle = findViewById(R.id.edtTitleInput);
        edtDesc = findViewById(R.id.edtDescInput);
        btnAddNewNote = findViewById(R.id.btnAddNewNote);
        dbHandler = new DBHandler(AddNoteActivity.this);

        btnAddNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtTitle.getText().toString();
                String desc = edtDesc.getText().toString();
                long createdTime = System.currentTimeMillis();

                if (title.isEmpty() || title.equals("")){
                    Toast.makeText(AddNoteActivity.this, "Add title", Toast.LENGTH_SHORT).show();
                }else if (desc.isEmpty() || desc.equals("")){
                    Toast.makeText(AddNoteActivity.this, "Add Description", Toast.LENGTH_SHORT).show();
                }else {
                    Notes notes = new Notes();
                    notes.setTitle(title);
                    notes.setDescription(desc);
                    notes.setCreatedTime(createdTime);
                    dbHandler.addNewNotes(notes);
                    Toast.makeText(AddNoteActivity.this, "Note Added", Toast.LENGTH_SHORT).show();
                    edtTitle.setText("");
                    edtDesc.setText("");
                    Intent intent = new  Intent(AddNoteActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}