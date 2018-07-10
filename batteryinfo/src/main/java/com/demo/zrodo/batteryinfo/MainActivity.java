package com.demo.zrodo.batteryinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private BatteryChangeInfo receiver;
    private TextView tv_power;
    private TextView tv_statue;
    private TextView tv_level;
    private ProgressBar progressBar_power;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new BatteryChangeInfo();
        tv_power = (TextView) findViewById(R.id.tv_power);
        tv_level = (TextView) findViewById(R.id.tv_level);
        tv_statue = (TextView) findViewById(R.id.tv_statue);
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

    private void registerBatteryInfo() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, filter);

    }

    private void unregisterBatteryInfo() {
        unregisterReceiver(receiver);
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
        }else {
            tv_level.setText("电池健康程度：unknown");
        }
        tv_power.setText("电池电量：" + level + "%");
        progressBar_power.setProgress(level);
        if (state == BatteryManager.BATTERY_STATUS_CHARGING) {
            tv_statue.setText("电池状态：充电中");
        } else if (state == BatteryManager.BATTERY_STATUS_NOT_CHARGING) {
            tv_statue.setText("电池状态：不充电");
        }else {
            tv_statue.setText("电池状态：unknown");
        }

    }
}
