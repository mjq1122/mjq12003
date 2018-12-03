package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Lenovo on 2018/11/22.
 */

public abstract class BaseFragment extends Fragment {
    private static final String TAG = "BaseFragment+++++";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return oncreateView(inflater, container, savedInstanceState);
    }

    protected abstract View oncreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            Log.d(TAG, "setUserVisibleHint: 可见");
            getDataFromNet();
        }
    }

    protected abstract void getDataFromNet();

}
