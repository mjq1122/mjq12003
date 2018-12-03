package com.bwei.week01exe1130;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 * Created by Lenovo on 2018/11/30.
 */

public class Flow extends FrameLayout {
    public Flow(@NonNull Context context) {
        super(context);
    }

    public Flow(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Flow(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Flow(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //获取控件宽度
        int width = getWidth();
        //定义常量行数
        int row=0;
        //子控件左边的坐标
        int disWidth=20;
        for (int i = 0; i <getChildCount() ; i++) {
            View view = getChildAt(i);
            //子控件的宽度
            int viewWidth = view.getWidth();
            //子控件的高度
            int viewHeight = view.getHeight();
            if(disWidth+viewWidth>width){
                row++;
                disWidth=20;
            }
            view.layout(disWidth,row*viewHeight,viewWidth+disWidth,viewHeight*(row+1));
            disWidth+=viewWidth;
        }
    }

}
