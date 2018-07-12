package com.demo.zrodo.batteryinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private final String TAG = "Main2Activity_app";
    private Button getusername1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate: " + getApplication() + this);
        getusername1=(Button) findViewById(R.id.btn_getusername2);
        getusername1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                My_app app =(My_app) getApplication();
                Toast.makeText(Main2Activity.this, app.getUsername(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: "+getApplicationContext()+this);
    }
}
