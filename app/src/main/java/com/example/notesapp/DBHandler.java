package com.example.notesapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "notesdb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "mynotes";

    private static final String ID_COL = "id";
    private static final String TITLE_COL = "title";
    private static final String DESCRIPTION_COL = "discription";
    private static final String CREATED_TIME = "createdTime";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + CREATED_TIME + " INTEGER)";

        db.execSQL(query);
    }

    public void addNewNotes(Notes notes) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TITLE_COL, notes.getTitle());
        values.put(DESCRIPTION_COL, notes.getDescription());
        values.put(CREATED_TIME, notes.getCreatedTime());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Notes> readNotes() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME +" ORDER BY "+ CREATED_TIME + " DESC", null);

        ArrayList<Notes> courseModalArrayList = new ArrayList<>();
        if (cursorCourses.moveToFirst()) {
            do {
                courseModalArrayList.add(new Notes(cursorCourses.getInt(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getLong(3)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return courseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
