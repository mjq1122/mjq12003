package com.bwei.week01exe1202;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Lenovo on 2018/12/2.
 */

public class MyView extends FrameLayout {
    public MyView(@NonNull Context context) {
        super(context);
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        /*//获取控件宽度
        int width = getWidth();
        //定义常量行数
        int row=0;
        //子控件左边的坐标
        int disWidth=10;
        for (int i = 0; i <getChildCount() ; i++) {
            View view = getChildAt(i);
            //子控件的宽度
            int viewWidth = view.getWidth();
            //子控件的高度
            int viewHeight = view.getHeight();
            if(disWidth+viewWidth>width){
                row++;
                disWidth=10;
            }
            view.layout(disWidth,row*viewHeight,disWidth+viewWidth,viewHeight*(row+1));
            disWidth+=viewWidth;
        }*/
        //获取控件宽度
        int width = getWidth();
        //定义行数
        int row=0;
        //获取子控件左边坐标
        int disWidth=20;
        for (int i = 0; i <getChildCount() ; i++) {
            View view = getChildAt(i);
            //子控件高度 宽度
            int viewHeight = view.getHeight();
            int viewWidth = view.getWidth();
            if(disWidth+viewWidth>width){
                row++;
                disWidth=10;
            }
            view.layout(disWidth,row*viewHeight,disWidth+viewWidth,viewHeight*(row+1));
            disWidth+=viewWidth;
        }

    }
}
