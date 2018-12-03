package com.example.lenovo.test01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private String url1 = "http://api.tianapi.com/social/?key=8623991caf556df53d5d341a5515656a&num=10";
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //使用网络数据
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(url1);
                    //建立连接
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    //设置连接的属性
                    con.setConnectTimeout(50000);
                    //获取响应码----200
                    int code = con.getResponseCode();
                    if(code==200){
                        InputStream inputStream = con.getInputStream();
                        Log.d(TAG, "onCreate: "+inputStream);
                        //流转字符串
                        String json=inputStreamToString(inputStream);
                        Log.d(TAG, "onCreate: "+json);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
    public static String inputStreamToString(InputStream inputStream){
        byte[] buff = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        int len=0;
        try {
            while ((len=inputStream.read(buff))!=-1){
                String s = new String(buff, 0, len);
                stringBuffer.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }



    private void initView() {
        Button get = findViewById(R.id.get);
        ListView list_view = findViewById(R.id.list_view);
    }
}
