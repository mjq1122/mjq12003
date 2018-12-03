package com.bwei.week01exe33;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import fragments.ShouYeFragment;
import fragments.WoDeFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        list = new ArrayList<Fragment>();
        list.add(new ShouYeFragment());
        list.add(new WoDeFragment());
        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),list);
        view_pager.setAdapter(adapter);
    }

    private void initViews() {
        view_pager = findViewById(R.id.view_pager);
        RadioGroup radio_group=findViewById(R.id.radio_group);
    }
}
