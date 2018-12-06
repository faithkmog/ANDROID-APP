package com.example.student.zfgscleaners;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" Create table user (name text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ueser");
    }

    public boolean insert(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", username);
        contentValues.put("password", password);

        long ins = db.insert("user", "null", contentValues);
        if (ins == -1) return false;
        else return true;

    }
    public boolean checkUsername(String username)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select* from user where name =?",new String[]{username});
        if(cursor.getCount()>0)
            return false;
        else return true;

    }

    public  boolean userpassword(String user, String passwd)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * From user where user =? and passwd =?", new String[] {user,passwd});
        if(cursor.getCount()>0) return true;
        else return false;
    }
}
