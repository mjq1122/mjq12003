package utils;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Lenovo on 2018/11/4.
 */

public class HttpUtils {
    public static final String ERROR1="网络请求失败";
    public static final String ERROR2="有异常";

    //单例模式
    private static HttpUtils httpUtils=new HttpUtils();
    private HttpLoadListener httpLoadListener;

    private HttpUtils(){};
    public static HttpUtils getHttpUtils(){
        if(httpUtils==null){
            httpUtils=new HttpUtils();
        }
        return httpUtils;
    }
    //封装
    public void get(String url){
        MyTask myTask = new MyTask();
        myTask.execute(url);
    }
    //使用asynctask
    class MyTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            //子线程进行网络请求
            String url1 = strings[0];
            try {
                URL u = new URL(url1);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setConnectTimeout(5000);
                if(con.getResponseCode()==200){
                    InputStream is = con.getInputStream();
                    //流转字符串
                    String json=inputStreamToString(is);
                    return json;
                }else{
                    return ERROR1;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ERROR2;
            }

        }
        //在主线程处理回调
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            switch (s){
                case ERROR1:
                    httpLoadListener.loadError(ERROR1);
                    break;
                case ERROR2:
                    httpLoadListener.loadError(ERROR2);
                    break;
                default:
                    httpLoadListener.loadSuccess(s);
                    break;
            }
        }
    }
    //定义接口
    public interface HttpLoadListener{
        void loadSuccess(String json);
        void loadError(String error);
    }
    //定义监听
    public void setOnHttpLoadListener(HttpLoadListener httpLoadListener){
        this.httpLoadListener=httpLoadListener;
    }
    public static String inputStreamToString(InputStream is) throws IOException {
            InputStreamReader input = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(input);
            StringBuilder builder = new StringBuilder();
            String str="";
            while((str=reader.readLine())!=null){
                builder.append(str);
            }
            reader.close();
            return builder.toString();
    }

}
