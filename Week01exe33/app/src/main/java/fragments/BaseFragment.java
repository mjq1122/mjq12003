package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lenovo on 2018/11/5.
 */

public abstract class BaseFragment extends Fragment {
    //视图开始创建的回调
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return addView(inflater,container,savedInstanceState);
    }

    protected abstract View addView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
    //创建视图的方法
    

    //视图创建完毕
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    //当activity创建完毕的回调方法
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
    //对用户是否可见的方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //请求网络数据
        if(isVisibleToUser){
            initNetData();
        }
    }

    protected abstract void initNetData();
}
