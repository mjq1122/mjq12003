package com.bwei.week02exe11.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwei.week02exe11.R;
import com.bwei.week02exe11.adapter.MyAdapter;
import com.bwei.week02exe11.beans.NewsBean;
import com.bwei.week02exe11.http.HttpConfig;
import com.bwei.week02exe11.utils.HttpUtils;
import com.bwei.week02exe11.view.XListView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class NearFragment extends Fragment{
    private static final String TAG = "NearFragment";
    private XListView list_view;
    private int page=0;
    private int type=0;
    private static List<NewsBean.NewslistBean> list=new ArrayList<>();
    private MyAdapter myAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fg_layout,null);
        list_view = view.findViewById(R.id.list_view);
        list_view.setPullLoadEnable(true);
        list_view.setPullRefreshEnable(true);
        list_view.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                //刷新
                page=1;
                type = 1;
                getDataFromNet(HttpConfig.news_url + "&page=" + page);
            }

            @Override
            public void onLoadMore() {
                //加载
                page=2;
                type = 1;
                getDataFromNet(HttpConfig.news_url + "&page=" + page);
            }
        });
        //设置适配器
        myAdapter=new MyAdapter(getActivity(),list);
        list_view.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            Log.d(TAG, "可见: ");
            getDataFromNet(HttpConfig.news_url+"&page="+page);
        }
    }
    //将加载网络的方法抽取出来
    public void getDataFromNet(String url){
            Log.d(TAG, "可见。。。。");
            HttpUtils httpUtils = HttpUtils.getHttpUtils();
            httpUtils.get(url);
            httpUtils.setOnHttpLoadLinsteren(new HttpUtils.HttpLoadLinsteren() {
                @Override
                public void loadSuccess(String json) {
                    Gson gson=new Gson();
                    NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                    List<NewsBean.NewslistBean> newslist = newsBean.getNewslist();
                    //设置适配器
                    switch (type){
                        case 0://第一次加载
                            list = newsBean.getNewslist();
                            MyAdapter myAdapter=new MyAdapter(getActivity(),list);
                            list_view.setAdapter(myAdapter);
                            break;
                        case 1://刷新
                            list = newsBean.getNewslist();
                            NearFragment.this.myAdapter.notifyDataSetChanged();
                            list_view.stopRefresh();
                            break;
                        case 2://加载更多
                            list.addAll(newslist);
                            NearFragment.this.myAdapter.notifyDataSetChanged();
                            list_view.stopLoadMore();
                            break;
                    }
                }

                @Override
                public void loadError(String error) {

                }
            });
    }
}
