package com.bwei.week02exe11;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwei.week02exe11.adapter.MyFragmentAdapter;
import com.bwei.week02exe11.fragments.AllFragment;
import com.bwei.week02exe11.fragments.NearFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> titles=new ArrayList<>();
    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        titles.add("附近影院");
        titles.add("全部影院");
        ViewPager view_pager=findViewById(R.id.view_pager);
        list = new ArrayList<>();
        list.add(new NearFragment());
        list.add(new AllFragment());
        MyFragmentAdapter fragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),list,titles);
        view_pager.setAdapter(fragmentAdapter);
    }
}
