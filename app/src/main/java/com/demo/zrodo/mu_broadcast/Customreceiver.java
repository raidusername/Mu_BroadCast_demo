package com.demo.zrodo.mu_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Customreceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Toast.makeText(context, "这是一条接收信息", Toast.LENGTH_LONG).show();
        //监听开机广播，开机启动
        Intent intent1=new Intent(context,MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//启动一个新的activity需要启动NEW_TASK
        context.startActivity(intent1);

    }
}
