package com.example.storytellerr.library2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by storytellerr on 12/5/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Event.db";
    public final String TABLE_NAME;
    public static final String COL_1 = "MON";
    public static final String COL_2 = "MON";
    public static final String COL_3 = "TUES";
    public static final String COL_4 = "WED";
    public static final String COL_5 = "THUS";
    public static final String COL_6 = "FRI";
    public static final String COL_7 = "SAT";
    public static final String COL_8 = "SUN";

    public DatabaseHelper(Context context,String eventName) {
        super(context, DATABASE_NAME, null, 1);
        TABLE_NAME ="";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID TEXT PRIMARY KEY ,MON INTEGER,TUES INTEGER,WED INTEGER,THUS INTEGER,FRI INTEGER,SUN INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id,Integer mon,Integer tues,Integer wed,Integer thus,Integer fri,Integer sat,Integer sun) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String sql ="SELECT PID FROM "+ TABLE_NAME +" WHERE PID="+ id;
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor.getString(0)==id)
        {
            contentValues.put(COL_2,mon+cursor.getString(1));
            contentValues.put(COL_3,tues+cursor.getString(2));
            contentValues.put(COL_4,wed+cursor.getString(3));
            contentValues.put(COL_5,thus+cursor.getString(4));
            contentValues.put(COL_6,fri+cursor.getString(5));
            contentValues.put(COL_7,sat+cursor.getString(6));
            contentValues.put(COL_8,sun+cursor.getString(7));
            long result = db.insert(TABLE_NAME,null ,contentValues);
            cursor.close();
            if(result == -1)
                return false;
            else
                return true;


        }
        else{
            contentValues.put("ID",id);
            contentValues.put(COL_2,mon);
            contentValues.put(COL_3,tues);
            contentValues.put(COL_4,wed);
            contentValues.put(COL_5,thus);
            contentValues.put(COL_6,fri);
            contentValues.put(COL_7,sat);
            contentValues.put(COL_8,sun);
            long result = db.insert(TABLE_NAME,null ,contentValues);
            cursor.close();
            if(result == -1)
                return false;
            else
                return true;

        }

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }

}
