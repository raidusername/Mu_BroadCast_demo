package com.demo.zrodo.saveactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class ScoreActivity extends AppCompatActivity {
    private Fragment fragment;
    private static final String TAG = "ScoreActivity_vv";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        FragmentManager manager=getSupportFragmentManager();
        if (manager.findFragmentByTag("ScoreFragment")==null){
            fragment=new ScoreFragment();
            manager.beginTransaction().replace(android.R.id.content,fragment,"ScoreFragment").commit();
        }

        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
