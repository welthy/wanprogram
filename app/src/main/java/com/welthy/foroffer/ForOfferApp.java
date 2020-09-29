package com.welthy.foroffer;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

public class ForOfferApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LitePal.initialize(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
