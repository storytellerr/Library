package com.example.storytellerr.library2;

import android.util.Log;

/**
 * Created by storytellerr on 1/5/18.
 */

public class Event {
    public final String tag="hello";

    public void Eventlog(String  s){
        Log.d(tag,s);
    }
}
