package com.demo.zrodo.myservices;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //IBinder
    //ServiceConnection 用户绑定客户端和服务的
    //进度监控
    private static final String TAG = "MainActivity";
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //客户端正常连接服务是，执行服务的绑定操作被调用
            MyService.MyBinder mb = (MyService.MyBinder) service;
            int setp = mb.myprocess();
            Log.d(TAG, "onServiceConnected: " + setp);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void operate(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service:
                //启动服务： 创建->启动->销毁
                //服务被创建，重复启动，只会启动，不会重复被创建，除非被销毁
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            case R.id.btn_destory_service:
                Intent intent1 = new Intent(this, MyService.class);
                stopService(intent1);
                break;
            case R.id.btn_bind_service:
                //作用：对service执行的任务获取进度数据
                //如果不存在    bind-> unbind 创建-绑定-解绑-销毁
                //如果存在     bing->unbind-> ondestory     绑定-解绑-销毁
                //BIND_AUTO_CREATE 服务若果不存在直接创建
                Intent intent2 = new Intent(this, MyService.class);
                bindService(intent2, conn, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind_service:
                unbindService(conn);
                break;
        }

    }
}
