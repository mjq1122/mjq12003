package com.bwei.week01exe11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;

import adapter.MyAdapter;
import beans.NewsBean;
import https.HttpConfig;
import utils.HttpUtils;

/**
 * 1.完善工具类
 * 2.缓存
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //一加载就显示
        final ListView list_view=findViewById(R.id.list_view);
        //请求网络
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
