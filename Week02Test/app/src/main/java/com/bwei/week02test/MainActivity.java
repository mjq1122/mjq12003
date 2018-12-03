package com.bwei.week02test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import fragment.MyFragment;
import fragment.ShouYeFragment;
import fragment.VideosFragment;

public class MainActivity extends AppCompatActivity{

    private ViewPager view_pager;
    private RadioGroup radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initViews();
        //设置fragment
        List<Fragment> list=new ArrayList<Fragment>();
        list.add(new ShouYeFragment());
        list.add(new VideosFragment());
        list.add(new MyFragment());
        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),list);
        view_pager.setAdapter(adapter);
    }

    private void initViews() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        view_pager = findViewById(R.id.view_pager);
        radio_group = findViewById(R.id.radio_group);
    }
}
