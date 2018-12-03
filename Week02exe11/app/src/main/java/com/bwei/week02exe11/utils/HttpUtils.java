package com.bwei.week02exe11.utils;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Lenovo on 2018/11/9.
 */

public class HttpUtils {
    //单例模式
    private static HttpUtils httpUtils=new HttpUtils();
    private HttpLoadLinsteren httpLoadLinsteren;

    private HttpUtils(){};
    public static HttpUtils getHttpUtils(){
        if(httpUtils==null){
            httpUtils=new HttpUtils();
        }
        return httpUtils;
    }
    //封装
    public void get(String url){
        new MyTask().execute(url);
    }
    //使用asynTask
    class MyTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String url1 = strings[0];
            try {
                URL url = new URL(url1);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(5000);
                if(con.getResponseCode()==200){
                    InputStream inputStream = con.getInputStream();
                    String json=inputStreamToString(inputStream);
                    return json;
                }else{
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s!=null){
                httpLoadLinsteren.loadSuccess(s);
            }else{
                httpLoadLinsteren.loadError("未加载到数据 ");
            }
        }
    }
    //转字符串
    private String inputStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader input = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(input);
        StringBuilder builder = new StringBuilder();
        String str="";
        while((str=reader.readLine())!=null){
            builder.append(str);
        }
        reader.close();
        return builder.toString();
    }
    //设置
    public interface HttpLoadLinsteren{
        void loadSuccess(String json);
        void loadError(String error);
    }
    //监听
    public void setOnHttpLoadLinsteren(HttpLoadLinsteren httpLoadLinsteren){
        this.httpLoadLinsteren=httpLoadLinsteren;
    }


}
