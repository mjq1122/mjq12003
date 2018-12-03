package com.bwei.monthtest1123;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import adapters.FragemtAdapter;
import adapters.LeftAdapter;
import app.MyApp;
import fragments.F1Fragment;
import fragments.F2Fragment;
import fragments.F3Fragment;

public class MainActivity extends AppCompatActivity {

    private ListView left_list_view;
    private ViewPager main_view_pager;
    private DrawerLayout main_drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initViews();
        //左侧 侧拉条目
        initLeft();
        //初始化主页面
        initFragments();
    }

    private void initFragments() {
        List<Fragment> list=new ArrayList<>();
        list.add(new F1Fragment());
        list.add(new F2Fragment());
        list.add(new F3Fragment());
        FragemtAdapter adapter=new FragemtAdapter(getSupportFragmentManager(),list);
        main_view_pager.setAdapter(adapter);
    }

    private void initLeft() {
        final List<String> list=new ArrayList<>();
        list.add("Auto.js");
        list.add("日志");
        list.add("帮助");
        list.add("无障碍服务");
        list.add("悬浮窗");
        list.add("连接电脑");
        list.add("关闭所有正在运行的脚本");
        LeftAdapter adapter=new LeftAdapter(MyApp.getContext(),list);
        left_list_view.setAdapter(adapter);
        left_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyApp.getContext(),list.get(position)+"",Toast.LENGTH_SHORT).show();
                main_drawer.closeDrawer(Gravity.START);
            }
        });
    }

    private void initViews() {
        main_drawer = findViewById(R.id.main_drawer);
        main_view_pager = findViewById(R.id.main_view_pager);
        left_list_view = findViewById(R.id.left_list_view);
    }
}
