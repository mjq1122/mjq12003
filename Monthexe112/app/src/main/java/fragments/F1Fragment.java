package fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.bwei.monthexe11.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import adapter.NewsAdapter;
import adapter.PicAdapter;
import app.MyApp;
import beans.NewsBean;
import beans.PicBean;
import http.HttpConfig;
import utils.HttpUtils;
import view.MyListView;

/**
 * Created by Lenovo on 2018/11/22.
 */

public class F1Fragment extends BaseFragment {
    private int page=1;
    private int type=0;
    private static final String TAG = "F1Fragment+++++";
    private View view;
    private PullToRefreshScrollView f1_pull_scroll;
    private ViewPager f1_view_pager;
    private MyListView f1_list_view;
    private NewsAdapter adapter;
    private List<NewsBean.DataBean> list;

    @Override
    protected View oncreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f1_layout, null);
        //初始化控件
        initViews();
        //刷新
        f1_pull_scroll.setMode(PullToRefreshBase.Mode.BOTH);
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

    private void initViews() {
        f1_pull_scroll = view.findViewById(R.id.f1_pull_scroll);
        f1_view_pager = view.findViewById(R.id.f1_view_pager);
        f1_list_view = view.findViewById(R.id.f1_list_view);
    }

    @Override
    protected void getDataFromNet() {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.listurl+page);
        httpUtils.setOnHttpLoadListener(new HttpUtils.HttpLoadListener() {
            @Override
            public void loadSuccess(String json) {
                Log.d(TAG, "loadSuccess: "+json);
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                list = newsBean.getData();
                switch (type){
                    case 0:
                        adapter = new NewsAdapter(MyApp.getContext(), list);
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
                //轮播图
                initPic();
            }

            @Override
            public void loadError(String error) {

            }
        });

    }
    //轮播图
    private void initPic() {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.adurl);
        httpUtils.setOnHttpLoadListener(new HttpUtils.HttpLoadListener() {
            @Override
            public void loadSuccess(String json) {
                Log.d(TAG, "loadSuccess: "+json);
                Gson gson=new Gson();
                PicBean picBean = gson.fromJson(json, PicBean.class);
                List<PicBean.DataBean> list = picBean.getData();
                List<ImageView> imageViews=new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    String url = list.get(i).getImg();
                    ImageView imageView = new ImageView(MyApp.getContext());
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ImageLoader.getInstance().displayImage(url,imageView,MyApp.getOptions());
                    imageViews.add(imageView);
                }
                PicAdapter adapter = new PicAdapter(imageViews);
                f1_view_pager.setAdapter(adapter);
                //自动轮播

            }

            @Override
            public void loadError(String error) {

            }
        });
    }
}
