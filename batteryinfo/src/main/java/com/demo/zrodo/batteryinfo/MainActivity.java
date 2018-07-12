package com.demo.zrodo.batteryinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BatteryChangeInfo receiver;
    private TextView tv_power;
    private TextView tv_statue;
    private TextView tv_level;
    private ProgressBar progressBar_power;
    private final String TAG = "MainActivity_app";
    private Button btn_second;
    private Button btn_startservice;
    private Button setusername;
    private Button getusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: " + getApplicationContext() + this);
        receiver = new BatteryChangeInfo();
        tv_power = (TextView) findViewById(R.id.tv_power);
        tv_level = (TextView) findViewById(R.id.tv_level);
        tv_statue = (TextView) findViewById(R.id.tv_statue);
        btn_second = (Button) findViewById(R.id.btn_second);
        setusername = (Button) findViewById(R.id.btn_setusername);
        getusername = (Button) findViewById(R.id.btn_getusername);
        btn_startservice = (Button) findViewById(R.id.btn_startservice);
        btn_second.setOnClickListener(this);
        btn_startservice.setOnClickListener(this);
        setusername.setOnClickListener(this);
        getusername.setOnClickListener(this);
        progressBar_power = (ProgressBar) findViewById(R.id.progressBar_power);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerBatteryInfo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterBatteryInfo();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        //需要保存状态的时候，被调用
        Log.d(TAG, "onSaveInstanceState: ");
        //
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + getApplicationContext() + this);
    }

    private void registerBatteryInfo() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, filter);

    }

    private void unregisterBatteryInfo() {
        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_second:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.btn_startservice:
                startService(new Intent(this, TestIntentServices.class));
                break;
            case R.id.btn_getusername:
                My_app app =(My_app) getApplication();
                Toast.makeText(MainActivity.this, app.getUsername(), Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_setusername:
                My_app app1 = (My_app) getApplication();
                app1.setUsername("zrodo");
                Toast.makeText(MainActivity.this, "设置的名字是： " + app1.getUsername(), Toast.LENGTH_LONG).show();
                break;
        }
    }


    class BatteryChangeInfo extends BroadcastReceiver {
        int health;
        int level;
        int state;
        private final String TAG = "BatteryChangeInfo";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action == Intent.ACTION_BATTERY_CHANGED) {
                health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, BatteryManager.BATTERY_HEALTH_GOOD);
                level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 1);
                state = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
                Log.d(TAG, "health：" + health + "  level:" + level + "  statue:" + state);
                updateBatteryInfo(health, level, state);
            }
        }
    }

    private void updateBatteryInfo(int health, int level, int state) {
        if (health == BatteryManager.BATTERY_HEALTH_GOOD) {
            tv_level.setText("电池健康程度：good");
        } else {
            tv_level.setText("电池健康程度：unknown");
        }
        tv_power.setText("电池电量：" + level + "%");
        progressBar_power.setProgress(level);
        if (state == BatteryManager.BATTERY_STATUS_CHARGING) {
            tv_statue.setText("电池状态：充电中");
        } else if (state == BatteryManager.BATTERY_STATUS_NOT_CHARGING) {
            tv_statue.setText("电池状态：不充电");
        } else {
            tv_statue.setText("电池状态：unknown");
        }

    }
}
