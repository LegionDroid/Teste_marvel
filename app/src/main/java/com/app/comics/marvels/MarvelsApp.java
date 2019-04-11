package com.app.comics.marvels;

import android.app.Application;

import com.facebook.stetho.Stetho;


public class MarvelsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
