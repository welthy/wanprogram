package com.welthy.foroffer.util;

import android.util.Log;

public class LogUtil {

    private static final String TAG = "welthy";

    public static void normal(String tag, String msg){
        if (FFConstants.DEBUG) {
            Log.d(TAG + "-->" + tag, msg);
        }
    }

    public static void d(String tag, String msg){
        if (FFConstants.DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg){
        if (FFConstants.DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void e(String tag, String msg){
        if (FFConstants.DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg){
        if (FFConstants.DEBUG) {
            Log.v(tag, msg);
        }
    }
}
