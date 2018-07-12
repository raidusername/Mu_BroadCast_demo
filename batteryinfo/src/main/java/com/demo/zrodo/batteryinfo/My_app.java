package com.demo.zrodo.batteryinfo;

import android.app.Application;
import android.util.Log;

public class My_app extends Application {
    final String TAG = "My_app";
private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + getApplicationContext() + this);
    }
}
