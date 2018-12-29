package com.example.beverly.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "myNotesDB.db";
    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "user_ID";
    public static final String COL_2 = "user_lastname";
    public static final String COL_3 = "user_firstname";
    public static final String COL_4 = "user_username";
    public static final String COL_5 = "user_email";
    public static final String COL_6 = "user_password";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + TABLE_NAME + "(user_ID INTEGER PRIMARY KEY AUTOINCREMENT, user_lastname text, user_firstname text, user_username text, user_email, user_password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME );
        onCreate(db);
    }

    //inserting data in the database
    public boolean insertData(String user_username, String user_email, String user_password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4,user_username);
        contentValues.put(COL_5,user_email);
        contentValues.put(COL_6,user_password);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    //check if the username exists
    public Boolean chkusername(String user_username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where user_username=?", new String[]{user_username});
        if (cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //check if the email address exists
    public Boolean chkemail(String user_email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where user_email=?", new String[]{user_email});
        if (cursor.getCount()>0)
            return false;
        else
            return true;
    }

    //check if the username and password is in the database
    public Boolean chkuserpassw(String user_username, String user_password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where user_username=? and user_password=?",new String[]{user_username,user_password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
