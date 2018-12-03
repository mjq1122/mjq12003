package fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;

import com.bwei.monthtest1123.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.List;

import adapters.ListAdapter;
import app.MyApp;
import beans.NewsBean;
import helper.MyHelper;
import http.HttpConfig;
import utils.HttpUtils;
import view.MyListView;

/**
 * Created by Lenovo on 2018/11/23.
 */

public class F1Fragment extends BaseFragment{
    private static final String TAG = "F1Fragment+++";
    private View view;
    private PullToRefreshScrollView f1_pull_scroll;
    private MyListView f1_list_view;
    private int page=1;
    private int type=0;
    private ListAdapter adapter;
    private List<NewsBean.DataBean> list;
    private MyHelper myHelper;
    private SQLiteDatabase database;

    @Override
    protected View oncreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f1_layout, null);
        //初始化控件
        f1_pull_scroll = view.findViewById(R.id.f1_pull_scroll);
        f1_list_view = view.findViewById(R.id.f1_list_view);
        //刷新 加载 监听
        f1_pull_scroll.setMode(PullToRefreshScrollView.Mode.BOTH);
        f1_pull_scroll.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                page=1;
                type=1;
                getDataFromNet();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                page++;
                type=2;
                getDataFromNet();
            }
        });
        return view;
    }

    @Override
    protected void getDataFromNet() {
        //数据库操作
        myHelper = new MyHelper(MyApp.getContext());
        database = myHelper.getReadableDatabase();
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.news_url+page);
        boolean b = httpUtils.hasNet(MyApp.getContext());
        //判断是否有网
        if(b){
            //有网
            httpUtils.setOnHttpLoadListener(new HttpUtils.HttpLoadListener() {

                @Override
                public void loadSuccess(String json) {
                    Log.d(TAG, "f1页面成功获取到数据"+json);
                    Gson gson=new Gson();
                    NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                    list = newsBean.getData();
                    switch (type){
                        case 0:
                            adapter = new ListAdapter(MyApp.getContext(), list);
                            f1_list_view.setAdapter(adapter);
                            break;
                        case 1:
                            adapter.notifyDataSetChanged();
                            f1_pull_scroll.onRefreshComplete();
                            break;
                        case 2:
                            List<NewsBean.DataBean> data = newsBean.getData();
                            list.addAll(data);
                            adapter.notifyDataSetChanged();
                            f1_pull_scroll.onRefreshComplete();
                            break;
                    }
                    //向数据库存数据
                    ContentValues values=new ContentValues();
                    values.put("content",json);
                    database.insert("news",null,values);

                }

                @Override
                public void loadError(String error) {

                }
            });
        }else{
            //没有网络 请求数据库
            getDataFromDb();
        }


    }

    private void getDataFromDb() {
        Cursor cursor = database.query("news", null, null, null, null, null, null);
        boolean b = cursor.moveToLast();
        if(b){
            String json = cursor.getString(cursor.getColumnIndex("content"));
            Gson gson=new Gson();
            gson.fromJson(json,NewsBean.class);
            ListAdapter adapter = new ListAdapter(MyApp.getContext(), list);
            f1_list_view.setAdapter(adapter);
        }
    }
}
