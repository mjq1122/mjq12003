package fragments;

import android.icu.lang.UScript;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.bwei.week03exe99.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import adapters.MyAdapter;
import adapters.PicAdapter;
import app.MyApp;
import beans.NewsBean;
import beans.PicBean;
import http.HttpConfig;
import utils.HttpUtils;

/**
 * 主页面
 * 加载数据 轮播图 上拉 下拉
 */

public class F1Fragment extends BeansFragment {
    private static final String TAG = "F1Fragment+++++++";
    private int page=1;
    private int type=0;
    private ListView f1_list_view;
    private ViewPager f1_view_pager;
    private PullToRefreshScrollView f1_pullview;
    private List<NewsBean.DataBean> list;
    private MyAdapter myAdapter;
    private MyHandler myHandler=new MyHandler();

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f1_layout, null);

        f1_pullview = view.findViewById(R.id.f1_pullview);
        f1_view_pager = view.findViewById(R.id.f1_view_pager);
        f1_list_view = view.findViewById(R.id.f1_list_view);

        f1_pullview.setMode(PullToRefreshScrollView.Mode.BOTH);
        f1_pullview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
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
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.listurl+page);
        httpUtils.setOnHttpLoadListener(new HttpUtils.HttpLoadListener() {
            @Override
            public void loadSuccess(String json) {
                //Log.d(TAG, "成功"+json);
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                list = newsBean.getData();
                myAdapter = new MyAdapter(MyApp.getContext(), list);
                switch (type){
                    case 0://第一次加载
                        f1_list_view.setAdapter(myAdapter);
                        break;
                    case 1://刷新
                        myAdapter.notifyDataSetChanged();
                        f1_pullview.onRefreshComplete();
                        break;
                    case 2://加载更多
                        List<NewsBean.DataBean> data = newsBean.getData();
                        list.addAll(data);
                        myAdapter.notifyDataSetChanged();
                        f1_pullview.onRefreshComplete();
                        break;
                }
                //加载轮播图
                getDataAd();
            }

            @Override
            public void loadError(String error) {

            }
        });
    }
    //加载轮播图
    private void getDataAd() {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.adurl);
        httpUtils.setOnHttpLoadListener(new HttpUtils.HttpLoadListener() {
            @Override
            public void loadSuccess(String json) {

                Gson gson=new Gson();
                PicBean picBean = gson.fromJson(json, PicBean.class);
                List<PicBean.DataBean> picList = picBean.getData();
                //Log.d(TAG, "``````````````"+picList);
                List<ImageView> imageViews=new ArrayList<>();
                for (int i = 0; i <picList.size() ; i++) {
                    String url = picList.get(i).getImg();
                    Log.d(TAG, "我的图片"+url);
                    ImageView imageView = new ImageView(MyApp.getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ImageLoader.getInstance().displayImage(url,imageView,MyApp.getOptions());
                    imageViews.add(imageView);
                }
                PicAdapter picAdapter = new PicAdapter(imageViews);
                f1_view_pager.setAdapter(picAdapter);
                //开始自动轮播
                myHandler.sendEmptyMessageDelayed(0,61000);
            }

            @Override
            public void loadError(String error) {

            }
        });
    }
    //handler
    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            int currentItem = f1_view_pager.getCurrentItem();
            f1_view_pager.setCurrentItem(++currentItem);
            myHandler.sendEmptyMessageDelayed(0,1000);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        myHandler.removeCallbacksAndMessages(null);
    }
}
