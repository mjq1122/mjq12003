package fragments.topfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.monthexe11.R;

import fragments.BaseFragment;

/**
 * Created by Lenovo on 2018/11/15.
 */

public class H2Fragment extends BaseFragment{
    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hot_layout, null);
        return view;
    }

    @Override
    protected void initNetData() {

    }
}
