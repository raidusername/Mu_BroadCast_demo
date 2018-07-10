package com.demo.zrodo.mu_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MuBroadcastReceiver extends BroadcastReceiver {
    String TAG="MuBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"intent："+ intent.getAction().toString());
        //监听开机广播，开机启动
        Intent intent1=new Intent(context,MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
