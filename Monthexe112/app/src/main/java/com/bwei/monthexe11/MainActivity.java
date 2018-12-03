package com.bwei.monthexe11;

import android.content.SharedPreferences;
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

import adapter.FragmentAdapter;
import adapter.LeftAdapter;
import app.MyApp;
import fragments.F1Fragment;
import fragments.F2Fragment;
import fragments.F3Fragment;
import fragments.F4Fragment;

public class MainActivity extends AppCompatActivity {

    private ListView left_list_view;
    private ViewPager main_view_pager;
    private DrawerLayout main_drawer;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化页面
        initViews();
        //初始化侧拉数据
        initLeftData();
        //fragment初始化
        initFragment();
    }

    private void initFragment() {
        List<Fragment> list=new ArrayList<>();
        list.add(new F1Fragment());
        list.add(new F2Fragment());
        list.add(new F3Fragment());
        list.add(new F4Fragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), MyApp.getContext(), list);
        main_view_pager.setAdapter(adapter);
    }

    private void initLeftData() {
        final List<String> list=new ArrayList<>();
        list.add("页面1");
        list.add("页面2");
        list.add("页面3");
        list.add("页面4");
        LeftAdapter leftAdapter=new LeftAdapter(MyApp.getContext(),list);
        left_list_view.setAdapter(leftAdapter);
        left_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyApp.getContext(),list.get(position)+"",Toast.LENGTH_SHORT).show();
                main_drawer.closeDrawer(Gravity.START);
                main_view_pager.setCurrentItem(position);
            }
        });
    }

    private void initViews() {
        main_drawer = findViewById(R.id.main_drawer);
        main_view_pager = findViewById(R.id.main_view_pager);
        left_list_view = findViewById(R.id.left_list_view);
    }
}
