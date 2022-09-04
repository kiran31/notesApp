package com.example.notesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


    Context context;
    ArrayList<Notes> notesList;

    public NotesAdapter(Context context, ArrayList<Notes> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.note_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
       holder.title.setText(notesList.get(position).title);
       holder.desc.setText(notesList.get(position).description);

       String formatedTime = DateFormat.getDateTimeInstance().format(notesList.get(position).getCreatedTime());
       holder.createdTime.setText(formatedTime);
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {

        TextView title, desc, createdTime;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtTitle);
            desc = itemView.findViewById(R.id.txtDesc);
            createdTime = itemView.findViewById(R.id.txtCreatedTime);
        }
    }
}
