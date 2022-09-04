package com.example.notesapp;

public class Notes {

    int id;
    String title;
    String description;
    long createdTime;

    public Notes() {
    }

    public Notes(int id, String title, String description, long createdTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdTime = createdTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }
}
