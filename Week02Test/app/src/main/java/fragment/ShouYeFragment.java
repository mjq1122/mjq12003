package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwei.week02test.R;
import com.google.gson.Gson;

import java.util.List;

import adapter.MyAdapter;
import beans.NewsBean;
import http.HttpConfig;
import utils.HttpUtils;
import view.XListView;

/**
 * Created by Lenovo on 2018/11/12.
 */

public class ShouYeFragment extends Fragment {
    private static final String TAG = "ShouYeFragment+++++++";
    private XListView list_view;
    private int page=0;
    private int type=0;
    private MyAdapter adapter;
    private List<NewsBean.NewslistBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sy_layout, null);
        Log.d(TAG, "onCreateView: +++++++++++");
        list_view = view.findViewById(R.id.list_view);
        list_view.setPullRefreshEnable(true);
        list_view.setPullLoadEnable(true);
        list_view.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                //刷新
                page=0;
                type=1;
                funtion(HttpConfig.news_url+"&page="+page);
                list_view.stopRefresh();
            }

            @Override
            public void onLoadMore() {
                //加载更多
                page++;
                type=2;
                funtion(HttpConfig.news_url+"&page="+page);
                list_view.stopLoadMore();
            }
        });
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            funtion(HttpConfig.news_url+"&page="+page);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    public void funtion(String url){
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(url);
        httpUtils.setOnHttpLoadListener(new HttpUtils.HttpLoadListener() {
            @Override
            public void loadSuccess(String json) {
                Log.d(TAG, "loadSuccess: "+json);
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                list = newsBean.getNewslist();
                switch (type){
                    case 0:
                        adapter = new MyAdapter(getActivity(), list);
                        list_view.setAdapter(adapter);
                        break;
                    case 1:
                        adapter.notifyDataSetChanged();
                        break;
                    case 2:
                        List<NewsBean.NewslistBean> newslist = newsBean.getNewslist();
                        list.addAll(newslist);
                        break;
                }

            }

            @Override
            public void loadError(String error) {

            }
        });
    }
}
