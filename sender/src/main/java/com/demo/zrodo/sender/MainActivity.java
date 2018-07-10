package com.demo.zrodo.sender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_sender;
    private final String CUSTOM_ACTION = "com.raid.sender";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_sender = (Button) findViewById(R.id.btn_sender);
        btn_sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(CUSTOM_ACTION);
                MainActivity.this.sendBroadcast(intent);
            }
        });
    }
}
