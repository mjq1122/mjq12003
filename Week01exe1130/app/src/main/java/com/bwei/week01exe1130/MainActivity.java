package com.bwei.week01exe1130;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private EditText mMainEdit;
    private List<String> list=new ArrayList<>();
    /**
     * 搜索
     */
    private Button mMainButt;
    private Flow mMainFlow1;
    /**
     * 清空内容
     */
    private Button mBtnClear;
    private FlowDataBase dataBase;
    private FrameLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //创建数据库
        dataBase = new FlowDataBase(this);
        List<String> list1 = dataBase.query();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list1.get(i));
            TextView textView = new TextView(MainActivity.this);
            mMainFlow1.addView(textView,params);
        }
        mMainButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                String text = mMainEdit.getText().toString();
                list.add(text);
                TextView textView = new TextView(MainActivity.this);
                textView.setText(MainActivity.this.list.get(MainActivity.this.list.size()-1));
                textView.setTextSize(20);
                textView.setPadding(10,10,10,10);
                dataBase.insert(text);
                mMainFlow1.addView(textView, params);

            }
        });
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainFlow1.removeAllViews();
                dataBase.delete();
            }
        });
    }

    private void initView() {
        mMainEdit = findViewById(R.id.main_edit);
        mMainButt = findViewById(R.id.main_butt);
        mMainFlow1 = findViewById(R.id.main_flow1);
        mBtnClear = findViewById(R.id.btn_clear);
    }
}
