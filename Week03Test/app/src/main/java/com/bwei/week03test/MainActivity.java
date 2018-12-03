package com.bwei.week03test;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapters.MyFragmentAdapter;
import fragments.F1Fragment;
import fragments.F2Fragment;
import fragments.F3Fragment;
import fragments.F4Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager main_view_pager=findViewById(R.id.main_view_pager);
        //创建集合
        List<Fragment> list=new ArrayList<>();
        list.add(new F1Fragment());
        list.add(new F2Fragment());
        list.add(new F3Fragment());
        list.add(new F4Fragment());
        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),list);
        main_view_pager.setAdapter(adapter);
    }
}
