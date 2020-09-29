package com.welthy.foroffer.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class ThreadUtil {

    private static Handler mMainHandler;
    private static Handler mWorkHandler;

    private static HandlerThread mWorkThread = new HandlerThread("work_thread");

    static {
        mWorkThread.start();

        mMainHandler = new Handler(Looper.getMainLooper());
        mWorkHandler = new Handler(mWorkThread.getLooper());
    }

    public static void runOnUiThread(Runnable r) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r.run();
        }else {
            mMainHandler.post(r);
        }
    }

    public static void runOnUiThreadDelay(Runnable r,long delay) {
        mMainHandler.postAtTime(r,delay);
    }

    public static void runOnWorkThread(Runnable r) {
        if (Looper.myLooper() == mWorkThread.getLooper()) {
            r.run();
        }else {
            mWorkHandler.post(r);
        }
    }

    public static void runOnWorkThreadDelay(Runnable r,long delay) {
        mWorkHandler.postDelayed(r,delay);
    }

    public static Handler getMainHandler() {
        return mMainHandler;
    }
}
