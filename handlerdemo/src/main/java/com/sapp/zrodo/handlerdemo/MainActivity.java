package com.sapp.zrodo.handlerdemo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_send;
    private TextView tv_show;
    private Handler handler1;
    private Handler handler2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_send = (Button) findViewById(R.id.btn_click);
        tv_show = (TextView) findViewById(R.id.tv_show);
        handler2 = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (handler2 != null) {
                    super.handleMessage(msg);
                    String str = (String) msg.obj;
                    tv_show.setText(str);
                }
            }
        };

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (handler1 != null) {
                    Message msg = new Message();
                    msg.what = 9;
                    handler1.sendMessage(msg);
                }

            }
        });
        new Thread(new Runnable() {

            @Override
            public void run() {
                String tomain ="hello ";
                Message message = new Message();
                message.obj = tomain;
                handler2.sendMessage(message);
//                Looper.prepare();
//                handler1 = new Handler() {
//                    @Override
//                    public void handleMessage(Message msg) {
//                        super.handleMessage(msg);
//                        int formmain = msg.what;
//                        String tomain = formmain + "hello ";
//                        Message message = new Message();
//                        message.obj = tomain;
//                        handler2.sendMessage(message);
//                    }
//                };
//                Looper.loop();
            }
        }).start();
    }

}
