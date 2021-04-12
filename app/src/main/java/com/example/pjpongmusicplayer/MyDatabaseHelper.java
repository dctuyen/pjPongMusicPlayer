package com.example.pjpongmusicplayer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteQueryBuilder;

public class MyDatabaseHelper extends SQLiteOpenHelper {

// ...
    private static final String DATABASE_NAME = "Account_Manager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ACCOUNT = "Accout";
    private static final String COLUMN_ACCOUNT_ID = "Account_Id";
    private static final String COLUMN_ACCOUNT_NAME = "Account_Name";
    private static final String COLUMN_ACCOUNT_PASSWORD = "Account_Password";
    private static final String COLUMN_ACCOUNT_USER_NAME = "Account_User_Name";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Script to create table.
//        String script = "CREATE TABLE " + TABLE_ACCOUNT + "("
//                + COLUMN_NOTE_ID + " INTEGER PRIMARY KEY," + COLUMN_NOTE_TITLE + " TEXT,"
//                + COLUMN_NOTE_CONTENT + " TEXT" + ")";
        // Execute script.
//        db.execSQL(script);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop table
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);


        // Recreate
        onCreate(db);
    }
// ...
}
