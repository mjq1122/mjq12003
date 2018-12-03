package com.bwei.day021128;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Lenovo on 2018/11/29.
 */

public class AddSubLayout extends LinearLayout implements View.OnClickListener{

    private Button btn_add;
    private TextView text_num;
    private Button btn_jian;

    public AddSubLayout(Context context) {
        super(context);
        initViews();
    }

    public AddSubLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public AddSubLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AddSubLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
    }

    public void initViews() {
        View view = View.inflate(getContext(), R.layout.car_add_sub_layout, this);
        btn_add = view.findViewById(R.id.btn_add);
        text_num = view.findViewById(R.id.text_num);
        btn_jian = view.findViewById(R.id.btn_jian);
        btn_add.setOnClickListener(this);
        btn_jian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String string_num = text_num.getText().toString();
        int num = Integer.parseInt(string_num);

        switch (v.getId()){
            case  R.id.btn_add:
                num++;
                text_num.setText(num+"");
                break;
            case  R.id.btn_jian:
                if(num==0){
                    Toast.makeText(getContext(),"数量不能少于0",Toast.LENGTH_SHORT).show();
                    return;
                }
                num--;
                text_num.setText(num+"");
                break;
        }
    }
}
