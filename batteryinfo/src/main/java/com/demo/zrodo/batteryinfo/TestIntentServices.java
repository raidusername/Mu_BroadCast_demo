package com.demo.zrodo.batteryinfo;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class TestIntentServices extends IntentService {
    private final String TAG="TestIntentServices";

    public TestIntentServices() {
        super("TestIntentServices");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.d(TAG, "onHandleIntent: "+getApplication()+this);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: "+getApplication()+this);
    }
}
