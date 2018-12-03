package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwei.week02exe22.R;
import com.google.gson.Gson;

import java.util.List;

import adapter.MyAdapter;
import beans.NewsBean;
import http.HttpConfig;
import utils.HttpUtils;
import view.XListView;

public class NearFragment extends Fragment{
    private static final String TAG = "NearFragment";
    private XListView list_view;
    private int page=0;
    private int type=0;//加载类型
    private MyAdapter adapter;
    private List<NewsBean.NewslistBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_layout, null);
        list_view = view.findViewById(R.id.list_view);
        list_view.setPullLoadEnable(true);
        list_view.setPullRefreshEnable(true);
        list_view.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                //刷新
                page=0;
                type=1;
                getDataFromNet(HttpConfig.news_url+"&page="+page);
                list_view.stopRefresh();
            }

            @Override
            public void onLoadMore() {
                //加载更多
                page++;
                type=2;
                getDataFromNet(HttpConfig.news_url+"&page="+page);
                list_view.stopLoadMore();
            }
        });


        return view;
    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            Log.d(TAG, "可见");
            getDataFromNet(HttpConfig.news_url+"&page="+page);
        }
    }
    public void getDataFromNet(String url){
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(HttpConfig.news_url);
        httpUtils.setOnHttpLoadLinsener(new HttpUtils.HttpLoadLinsener() {
            @Override
            public void loadSuccess(String json) {
                Log.d(TAG, "loadSuccess: "+json);
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                Log.d(TAG, "loadSuccess: "+newsBean.getNewslist());
                list = newsBean.getNewslist();
                switch (type){
                    case 0://第一次加载
                        adapter = new MyAdapter(getActivity(), list);
                        list_view.setAdapter(adapter);
                        break;
                    case 1://刷新
                        adapter.notifyDataSetChanged();
                        break;
                    case 2://加载更多
                        List<NewsBean.NewslistBean> newslist = newsBean.getNewslist();
                        list.addAll(newslist);
                        adapter.notifyDataSetChanged();
                        break;
                }

                Log.d(TAG, "成功");
            }

            @Override
            public void loadError(String error) {

            }
        });
    }
}
