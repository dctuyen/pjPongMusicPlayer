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
    private static final String TABLE_USER = "TB_User";
    private static final String COLUMN_USER_ID = "User_Id";
    private static final String COLUMN_USER_NAME = "User_Name";
    private static final String COLUMN_USER_PHONE = "User_Phone_Number";
    private static final String COLUMN_USER_BIRTHDAY = "User_Birthday";
    private static final String COLUMN_USER_ACCOUNT = "User_Account";
    private static final String COLUMN_USER_PASSWORD = "User_Password";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Script to create table.
        String script = "CREATE TABLE " + TABLE_USER + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_PHONE + " TEXT," + COLUMN_USER_BIRTHDAY+"INT,"+ COLUMN_USER_ACCOUNT+" TEXT,"+COLUMN_USER_PASSWORD+ " TEXT)";
        //Execute script.
        db.execSQL(script);
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
