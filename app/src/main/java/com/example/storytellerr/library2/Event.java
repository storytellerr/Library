package com.example.storytellerr.library2;

import android.util.Log;

/**
 * Created by storytellerr on 1/5/18.
 */

public class Event {
    public static final String tag="hello";

    public static void Eventlog(String  s){
        Log.d(tag,s);
    }
}
