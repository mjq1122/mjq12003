package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.bwei.week01text.R;
import com.google.gson.Gson;

import adapter.ListsAdapter;
import beans.NewsBean;
import http.HttpUtils;
import utils.UtilsConfig;

/**
 * Created by Lenovo on 2018/11/5.
 */

public class Fragment1 extends Fragment {

    private ListView list_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(null,R.layout.fragment1_layout, container);
        list_view=view.findViewById(R.id.list_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //网络请求
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.get(UtilsConfig.news_url);
        httpUtils.setHttpLoadListener(new HttpUtils.HttpLoadListener() {
            @Override
            public void HttpSuccess(String json) {
                Gson gson=new Gson();
                NewsBean newsBean = gson.fromJson(json, NewsBean.class);
                if(newsBean.getCode()==200){
                    ListsAdapter adapter=new ListsAdapter(getActivity(),newsBean.getNewslist());
                    list_view.setAdapter(adapter);
                }
            }

            @Override
            public void HttpError(String error) {

            }
        });
    }

}
