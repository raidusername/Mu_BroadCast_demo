package com.demo.zrodo.saveactivity;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivityAAA";
    private TextView tv_time;
    private EditText edt_world;
    private long createrime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_time = (TextView) findViewById(R.id.tv_time);
        edt_world = (EditText) findViewById(R.id.edt_world);
        if (savedInstanceState != null) {
            //进行恢复数据
            createrime = savedInstanceState.getLong("creadtetime");
        } else {
            createrime = System.currentTimeMillis();
        }

        String formrime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(createrime);
        tv_time.setText(formrime);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //保存状态
        outState.putLong("creadtetime", this.createrime);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}
