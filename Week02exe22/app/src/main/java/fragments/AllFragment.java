package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bwei.week02exe22.R;
import com.google.gson.Gson;

import adapter.MyAdapter;
import beans.NewsBean;
import http.HttpConfig;
import utils.HttpUtils;

/**
 * Created by Lenovo on 2018/11/11.
 */

public class AllFragment extends Fragment{
    private static final String TAG = "AllFragment";
    private ListView list_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_layout, null);
        list_view = view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            Log.d(TAG, "可见");
            HttpUtils httpUtils = HttpUtils.getHttpUtils();
            httpUtils.get(HttpConfig.news_url);
            httpUtils.setOnHttpLoadLinsener(new HttpUtils.HttpLoadLinsener() {
                @Override
                public void loadSuccess(String json) {
                    Gson gson=new Gson();
                    NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                    Log.d(TAG, "loadSuccess: "+newsBean.getNewslist());
                    MyAdapter adapter=new MyAdapter(getActivity(),newsBean.getNewslist());
                    list_view.setAdapter(adapter);
                    Log.d(TAG, "成功");
                }

                @Override
                public void loadError(String error) {

                }
            });

        }
    }
}
