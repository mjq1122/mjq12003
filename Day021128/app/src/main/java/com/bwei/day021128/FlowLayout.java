package com.bwei.day021128;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Lenovo on 2018/11/29.
 */

public class FlowLayout extends FrameLayout {
    public FlowLayout(@NonNull Context context) {
        super(context);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FlowLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //获取本控件的宽度
        int width=getWidth();
        //行数
        int row=0;
        //子控件的左边坐标
        int disWidth=0;

        for (int i = 0; i < getChildCount(); i++) {
            View view=getChildAt(i);
            int viewWidth = view.getWidth();
            int viewHeight = view.getHeight();
            if (disWidth+viewWidth>width){
                row++;
                disWidth=0;
            }
            view.layout(disWidth,row*viewHeight,disWidth+viewWidth,viewHeight*(row+1));
            disWidth+=viewWidth;
        }
        
    }
}
