package fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwei.week01exe33.R;
import com.google.gson.Gson;

import adapter.MyAdapter;
import beans.NewsBean;
import http.HttpConfig;
import utils.HttpUtils;

/**
 * Created by Lenovo on 2018/11/5.
 */

public class WoDeFragment extends BaseFragment{
    private static final String TAG = "ShouYeFragment";
    private ListView list_view;

    @Override
    protected View addView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment1_layout,null);
        list_view = view.findViewById(R.id.f1_listview);
        return view;
    }

    @Override
    protected void initNetData() {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.news_utl);
        httpUtils.setOnHttpLoadListener(new HttpUtils.HttpLoadListener() {
            @Override
            public void loadSuccess(String json) {
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                if(newsBean.getCode()==200){
                    MyAdapter adapter=new MyAdapter(getActivity(),newsBean.getNewslist());
                    list_view.setAdapter(adapter);
                }else{
                    Log.d(TAG, "数据有问题");
                }
            }

            @Override
            public void loadError(String error) {

            }
        });
    }
}
