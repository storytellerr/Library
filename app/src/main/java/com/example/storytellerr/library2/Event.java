package com.example.storytellerr.library2;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

/**
 * Created by storytellerr on 1/5/18.
 */

public class Event {
    public static final String tag="hello";


    public static void Eventlog(String  s){
        Log.d(tag,s);
    }

    public static void EventLog(Context cn,String eventName,Integer a[])
    {
        DatabaseHelper myDb = new DatabaseHelper(cn,eventName);
        boolean isInserted = myDb.insertData(eventName,a[1],a[2],a[3],a[4],a[5],a[6],a[7]);
        if(isInserted == true) {
            Log.d("Event.java", "inserted");
            Cursor res = myDb.getAllData();
            if (res.getCount() == 0) {
                // show message
                Log.d("Event.java", "error");
                return;
            }

            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()) {
                buffer.append("Id :" + res.getString(0) + "\n");
                buffer.append("Name :" + res.getString(1) + "\n");
                buffer.append("Surname :" + res.getString(2) + "\n");
                buffer.append("Marks :" + res.getString(3) + "\n\n");
            }

            // Show all data
            Log.d("Event.java", buffer.toString());
        }
        else
            Log.d("Event.java","not inserted");


    }
}
