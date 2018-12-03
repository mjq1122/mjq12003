package com.bwei.week01exe22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import adapter.MyAdapter;
import beans.NewsBean;
import https.HttpConfig;
import utils.HttpUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list_view=findViewById(R.id.list_view);
        //网络请求
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.new_url);
        //设置监听
        httpUtils.setOnHttpLoadListener(new HttpUtils.HttpLoadListener() {
            @Override
            public void loadSuccess(String json) {
                Gson gson = new Gson();
                NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                if(newsBean.getCode()==200){
                    MyAdapter myAdapter = new MyAdapter(MainActivity.this, newsBean.getNewslist());
                    list_view.setAdapter(myAdapter);
                }
            }

            @Override
            public void loadError(String error) {

            }
        });

    }
}
