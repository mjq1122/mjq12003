package com.bwei.week03exe99;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.LeftAdapter;
import adapters.MyFragmentAdapter;
import app.MyApp;
import fragments.F1Fragment;
import fragments.F2Fragment;
import fragments.F3Fragment;
import fragments.F4Fragment;
import http.HttpConfig;

public class MainActivity extends AppCompatActivity {

    private ListView left_list_view;
    private DrawerLayout main_drawer;
    private ViewPager main_view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化页面
        initViews();
        //初始化侧拉数据
        initLeftData();
        //主页面fragment
        initFragments();
    }

    private void initFragments() {
        List<Fragment> list=new ArrayList<>();
        list.add(new F1Fragment());
        list.add(new F2Fragment());
        list.add(new F3Fragment());
        list.add(new F4Fragment());
        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), list);
        main_view_pager.setAdapter(myFragmentAdapter);
    }

    private void initLeftData() {
        final List<String> list = HttpConfig.getleftData();
        LeftAdapter leftAdapter = new LeftAdapter(MainActivity.this, list);
        left_list_view.setAdapter(leftAdapter);
        left_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyApp.getContext(),list.get(position).toString(),Toast.LENGTH_SHORT).show();
                main_drawer.closeDrawer(Gravity.START);
            }
        });
    }

    private void initViews() {
        main_view_pager = findViewById(R.id.main_view_pager);
        main_drawer = findViewById(R.id.main_drawer);
        left_list_view = findViewById(R.id.left_list_view);
    }
}
