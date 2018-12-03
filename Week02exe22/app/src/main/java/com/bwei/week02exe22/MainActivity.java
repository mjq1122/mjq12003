package com.bwei.week02exe22;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import fragments.AllFragment;
import fragments.NearFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化页面
        initViews();
    }

    private void initViews() {
        ViewPager view_pager=findViewById(R.id.view_pager);
        List<Fragment> list=new ArrayList<>();
        list.add(new NearFragment());
        list.add(new AllFragment());
        List<String> titles=new ArrayList<String>();
        titles.add("附近影院");
        titles.add("全部影院");
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), list, titles);
        view_pager.setAdapter(adapter);
    }
}
