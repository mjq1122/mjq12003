package http;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import beans.NewsBean;

/**
 * Created by Lenovo on 2018/11/5.
 */

public class HttpUtils {
    private static final String ERROR1="有异常";
    private static final String ERROR2="未加载";

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
    public void get(String url){
        MyAsyntask myAsyntask = new MyAsyntask();
        myAsyntask.execute(url);

    }

    //使用asyntask
     class MyAsyntask extends AsyncTask<String, Void, String> {
        private HttpLoadListener httpLoadListener;
        //子线程操作

        protected String  doInBackground(String... strings) {
            String url1 = strings[0];
            try {
                URL url = new URL(url1);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(5000);
                if(con.getResponseCode()==200){
                    InputStream inputStream = con.getInputStream();
                    String json=inputStreamToString(inputStream);
                    return json;
                }else return ERROR2;

            } catch (Exception e) {
                e.printStackTrace();
                return ERROR1;
            }
        }
        //返回数据
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            switch (s){
                case ERROR1:
                    httpLoadListener.HttpError(ERROR1);
                    break;
                case ERROR2:
                    httpLoadListener.HttpError(ERROR2);
                    break;
                default:
                    httpLoadListener.HttpSuccess(s);
                    break;
            }
        }
    }
    //建立监听
    public interface HttpLoadListener{
        void HttpSuccess (String json);
        void HttpError (String error);
    }
    //设置
    public void setHttpLoadListener(HttpLoadListener httpLoadListener){
        this.httpLoadListener=httpLoadListener;
    }
    //流转字符串
    public static String inputStreamToString(InputStream InputStream) throws IOException {
        InputStreamReader input = new InputStreamReader(InputStream);
        BufferedReader reader = new BufferedReader(input);
        StringBuilder builder = new StringBuilder();
        String str="";
        while ((str=reader.readLine())!=null){
            builder.append(str);
        }
        reader.close();
        return builder.toString();
    }
}
