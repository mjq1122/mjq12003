package fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.monthexe11.R;

/**
 * Created by Lenovo on 2018/11/15.
 */

public class Rb3Fragment extends BaseFragment {
    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rb3_layout, null);
        return view;
    }

    @Override
    protected void initNetData() {

    }
}
