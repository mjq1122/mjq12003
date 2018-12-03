package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.monthtest1123.R;

/**
 * Created by Lenovo on 2018/11/23.
 */

public class F3Fragment extends BaseFragment{
    @Override
    protected View oncreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f3_layout, null);
        return view;
    }

    @Override
    protected void getDataFromNet() {

    }
}
