package com.demo.zrodo.myservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileDescriptor;

public class MyService extends Service {
    private static final String TAG = "MyService";
    int i;
    public MyService() {
    }

    //IBinder在Android 中用于远程操作对象的一个基本接口
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG, "onBind: ");
        //throw new UnsupportedOperationException("Not yet implemented");

        //Binder 实现 IBinder 中的所有方法
        return new MyBinder();
    }

    //对于onBind方法而言，要求返回IBinder对象
    //实际上，自己定义一个内部类，继承Binder
    class MyBinder extends Binder {
        //自定义实现进度监控
        public int myprocess(){
            return i;
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (i = 0; i <= 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }
}
