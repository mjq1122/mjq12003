package com.bwei.week01text;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.FragmentAdapter;
import fragment.Fragment1;
import fragment.Fragment2;
import fragment.Fragment3;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件
        ViewPager view_pager=findViewById(R.id.view_pager);
        final RadioGroup radio_group=findViewById(R.id.radio_group);
        //建立集合
        List<Fragment> list=new ArrayList<Fragment>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        //建立适配器
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(),list);
        view_pager.setAdapter(adapter);
        //点击切换
        /*radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radio_group.setBottom(radio_group.getCheckedRadioButtonId());
            }
        });*/
    }
}
