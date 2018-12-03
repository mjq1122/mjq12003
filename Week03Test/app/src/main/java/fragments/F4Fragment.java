package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.week03test.R;

/**
 * Created by Lenovo on 2018/11/19.
 */

public class F4Fragment extends BaseFragment{
    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2_layout, null);
        return view;
    }

    @Override
    protected void getDataFromNet() {

    }
}
