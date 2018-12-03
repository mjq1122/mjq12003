package com.bwei.monthexe11;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 闪屏页面
 */
public class MainActivity extends AppCompatActivity {
    private int t=3;
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                t--;
                jump_time.setText("跳过"+t+"s");
                if(t==0){
                    Intent intent = new Intent(MainActivity.this, DrtailActivity.class);
                    startActivity(intent);
                }else{
                    handler.sendEmptyMessageDelayed(0,1000);
                }
            }
        }
    };
    private TextView jump_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jump_time = findViewById(R.id.jump_time);
        handler.sendEmptyMessageDelayed(0,1000);
    }
}
