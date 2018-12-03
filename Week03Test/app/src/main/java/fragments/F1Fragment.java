package fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import com.bwei.week03test.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import adapters.MyListAdapter;
import adapters.PicAdapter;
import app.MyApp;
import beans.NewsBean;
import beans.PicBean;
import http.HttpConfig;
import utils.HttpUtils;
import view.MyListView;

/**
 * Created by Lenovo on 2018/11/19.
 */

public class F1Fragment extends BaseFragment{
    private static final String TAG = "F1Fragment+++++++";
    private View view;
    private MyListView f1_list_view;
    private int page=1;
    private int type=0;
    private PullToRefreshScrollView f1_pull_view;
    private MyListAdapter adapter;
    private List<NewsBean.NewslistBean> newslist;
    private ViewPager f1_view_pager;

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f1_layout, null);
        //初始化控件
        initViews();
        //加载数据
        f1_pull_view.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
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
        //轮播
        //luenBo();
        return view;
    }

    private void luenBo() {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.pic_url);
        httpUtils.setOnHttpLoadLinserener(new HttpUtils.HttpLoadLinserener() {
            @Override
            public void loadSuccess(String json) {
                Log.d(TAG, "loadSuccess: "+json);
                Gson gson=new Gson();
                PicBean picBean = gson.fromJson(json, PicBean.class);
                List<PicBean.DataBean> data = picBean.getData();
                List<ImageView> imageViews=new ArrayList<>();
                for (int i = 0; i <data.size(); i++) {
                    String url = data.get(i).getImg();
                    ImageView imageView = new ImageView(MyApp.getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ImageLoader.getInstance().displayImage(url,imageView,MyApp.getOptions());
                    imageViews.add(imageView);
                }
                PicAdapter picAdapter = new PicAdapter(imageViews);
                f1_view_pager.setAdapter(picAdapter);

            }

            @Override
            public void loadError(String error) {

            }
        });
    }

    private void initViews() {
        f1_view_pager = view.findViewById(R.id.f1_view_pager);
        f1_pull_view = view.findViewById(R.id.f1_pull_view);
        f1_list_view = view.findViewById(R.id.f1_list_view);
    }

    @Override
    protected void getDataFromNet() {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.news_url+"&page="+page);
        httpUtils.setOnHttpLoadLinserener(new HttpUtils.HttpLoadLinserener() {
            @Override
            public void loadSuccess(String json) {
                Log.d(TAG, "loadSuccess: "+json);
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                newslist = newsBean.getNewslist();
                switch (type){
                    case 0:
                        adapter = new MyListAdapter(MyApp.getContext(), newslist);
                        f1_list_view.setAdapter(adapter);
                        break;
                    case 1:
                        adapter.notifyDataSetChanged();
                        f1_pull_view.onRefreshComplete();
                        break;
                    case 2:
                        List<NewsBean.NewslistBean> newslist1 = newsBean.getNewslist();
                        newslist.addAll(newslist1);
                        adapter.notifyDataSetChanged();
                        f1_pull_view.onRefreshComplete();
                        break;
                }
                luenBo();

            }

            @Override
            public void loadError(String error) {

            }
        });
    }
}
