package com.example.quanlysinhvien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "SQLite";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Student_Manager";

    // Table name: Note.
    protected static final String TABLE_NOTE = "Student";
    protected static final String CONTACTS_COLUMN_ID ="Note_ID";
    protected static final String CONTACTS_COLUMN_NAME ="Note_Name";
    protected static final String CONTACTS_COLUMN_PHONE ="Note_Phone";
    protected static final String CONTACTS_COLUMN_EMAIL ="Note_Email";
    protected static final String CONTACTS_COLUMN_STREET = "Note_Street";
    protected static final String CONTACTS_COLUMN_CITY = "Note_City";


    public DBHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "MyDatabaseHelper.onCreate ... ");
        // Script.
        String script = "CREATE TABLE " + TABLE_NOTE + "(" + CONTACTS_COLUMN_ID + " INTEGER PRIMARY KEY,"
                + CONTACTS_COLUMN_NAME + " TEXT," + CONTACTS_COLUMN_PHONE + " TEXT," +  CONTACTS_COLUMN_EMAIL + " TEXT,"
                + CONTACTS_COLUMN_STREET + " TEXT, " + CONTACTS_COLUMN_CITY + " TEXT" +")";
        // Execute Script.
        db.execSQL(script);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i(TAG, "MyDatabaseHelper.onUpgrade ... ");
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);

        // Create tables again
        onCreate(db);
    }


    // If Note table has no data
    // default, Insert 2 records.
    public void createDefaultNotesIfNeed()  {
        int count = this.getNotesCount();
        if(count ==0 ) {
            Note note1 = new Note("1",
                    "Duy", "0772512251", "maiduybigbang@gmail.com", "87 Cao Thắng", "Đà Nẵng");
            this.insertContact(note1);
        }
    }


    public void insertContact(Note note) {
        Log.i(TAG, "MyDatabaseHelper.addNote ... " + note.getNoteName());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CONTACTS_COLUMN_ID, note.getNoteId());
        values.put(CONTACTS_COLUMN_NAME, note.getNoteName());
        values.put(CONTACTS_COLUMN_PHONE, note.getNotePhone());
        values.put(CONTACTS_COLUMN_EMAIL, note.getNoteEmail());
        values.put(CONTACTS_COLUMN_STREET, note.getNoteStreet());
        values.put(CONTACTS_COLUMN_CITY, note.getNoteCity());

        // Inserting Row
        db.insert(TABLE_NOTE, null, values);

        // Closing database connection
        db.close();
    }


    public Note getData(int id) {
        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NOTE, new String[] { CONTACTS_COLUMN_ID,
                        CONTACTS_COLUMN_NAME, CONTACTS_COLUMN_PHONE,CONTACTS_COLUMN_EMAIL,
                        CONTACTS_COLUMN_STREET,CONTACTS_COLUMN_CITY }, CONTACTS_COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Note note = new Note(cursor.getString(0),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3),cursor.getString(4),cursor.getString(5));
        // return note
        return note;
    }


    public List<Note> getAllContacts() {
        Log.i(TAG, "MyDatabaseHelper.getAllNotes ... " );

        List<Note> noteList = new ArrayList<Note>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NOTE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setNoteId(cursor.getString(0));
                note.setNoteName(cursor.getString(1));
                note.setNotePhone(cursor.getString(2));
                note.setNoteEmail(cursor.getString(3));
                note.setNoteStreet(cursor.getString(4));
                note.setNoteCity(cursor.getString(5));
                // Adding note to list
                noteList.add(note);
            } while (cursor.moveToNext());
        }

        // return note list
        return noteList;
    }

    public int getNotesCount() {
        Log.i(TAG, "MyDatabaseHelper.getNotesCount ... " );

        String countQuery = "SELECT  * FROM " + TABLE_NOTE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();

        // return count
        return count;
    }


    public int updateContact(Note note) {
        Log.i(TAG, "MyDatabaseHelper.updateNote ... "  + note.getNoteName());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CONTACTS_COLUMN_ID, note.getNoteId());
        values.put(CONTACTS_COLUMN_NAME, note.getNoteName());
        values.put(CONTACTS_COLUMN_PHONE, note.getNotePhone());
        values.put(CONTACTS_COLUMN_EMAIL, note.getNoteEmail());
        values.put(CONTACTS_COLUMN_STREET, note.getNoteStreet());
        values.put(CONTACTS_COLUMN_CITY, note.getNoteCity());

        // updating row
        return db.update(TABLE_NOTE, values, CONTACTS_COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getNoteId())});
    }

    public void deleteContact(Note note, int id) {
        Log.i(TAG, "MyDatabaseHelper.updateNote ... " + note.getNoteName() );

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTE, CONTACTS_COLUMN_ID + " = ?",
                new String[] { String.valueOf(note.getNoteId()) });
        db.close();
    }

}