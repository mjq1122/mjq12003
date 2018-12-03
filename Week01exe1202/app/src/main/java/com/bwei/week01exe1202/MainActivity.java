package com.bwei.week01exe1202;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edit_text;
    private Button btn_add;
    private MyView main_myView;
    private Button btn_clear;
    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initViews();
        //点击按钮添加历史
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                String text = edit_text.getText().toString();
                list.add(text);
                TextView textView = new TextView(MainActivity.this);
                textView.setText(list.get(list.size()-1));
                textView.setTextSize(20);
                textView.setPadding(10,10,10,10);
                main_myView.addView(textView,params);*/

                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                String text = edit_text.getText().toString();
                list.add(text);
                TextView textView = new TextView(MainActivity.this);
                textView.setText(list.get(list.size()-1));
                textView.setTextSize(20);
                textView.setPadding(10,10,10,10);
                main_myView.addView(textView);
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_myView.removeAllViews();
            }
        });

    }

    private void initViews() {
        edit_text = findViewById(R.id.edit_text);
        btn_add = findViewById(R.id.btn_add);
        main_myView = findViewById(R.id.main_myView);
        btn_clear = findViewById(R.id.btn_clear);
    }
}
