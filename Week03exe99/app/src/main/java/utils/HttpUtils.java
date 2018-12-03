package utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络请求工具类：
 * 1.使用单利模式，保证项目中只有这一个实例，减少内存消耗，提高运行效率
 */

public class HttpUtils {
    public static final String ERROR1 = "网络加载失败";
    public static final String ERROR2 = "有异常";
    //单利模式-饿汉式
    private static HttpUtils httpUtils = new HttpUtils();
    private HttpLoadListener httpLoadListener;

    private HttpUtils() {
    }

    public static HttpUtils getHttpUtils() {
        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }

    //封装，在这里调用AsncTask方法
    public void get(String url) {
        MyTask myTask = new MyTask();
        myTask.execute(url);//传入url地址
    }

    //使用AsyncTask
    class MyTask extends AsyncTask<String, Void, String> {
        //        doInBackground 在后台线程执行的方法
        @Override
        protected String doInBackground(String... strings) {
            //在子线程 进行网络请求
            String url1 = strings[0];

            try {
                URL u = new URL(url1);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setConnectTimeout(5000);
                if (con.getResponseCode() == 200) {
                    InputStream is = con.getInputStream();
                    //将流转成---json
                    String json = inputStream2String(is);
                    return json;
                } else {
                    return ERROR1;
                }

            } catch (IOException e) {
                e.printStackTrace();
                return ERROR2;
            }
        }

        //在主线程处理回调
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            switch (s) {
                case ERROR1:
//                    加载失败
                    httpLoadListener.loadError(ERROR1);
                    break;
                case ERROR2:
                    httpLoadListener.loadError(ERROR2);

                    break;
                default:
//                    加载成功
                    httpLoadListener.loadSuccess(s);
                    break;
            }
        }
    }

    //定义接口
    public interface HttpLoadListener {
        //        接口里面成功失败的回调方法的定义
        void loadSuccess(String json);

        void loadError(String error);
    }

    //对外部提供的设置监听的方法
    public void setOnHttpLoadListener(HttpLoadListener httpLoadListener) {
        this.httpLoadListener = httpLoadListener;
    }

    //判断网络状态
    public boolean hasNet(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        return true;
    }

    //将流转成字符串
    public static String inputStream2String(InputStream inputStream) throws IOException {

        InputStreamReader isr = new InputStreamReader(inputStream);
        char[] chars = new char[1024];
        int len = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while ((len = isr.read(chars)) != -1) {
            String s = new String(chars, 0, len);
            stringBuffer.append(s);
        }
        return stringBuffer.toString();

    }
}
