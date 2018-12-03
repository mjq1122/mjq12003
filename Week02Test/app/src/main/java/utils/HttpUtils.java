package utils;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Lenovo on 2018/11/12.
 */

public class HttpUtils {
    private static final String TAG = "HttpUtils+++++++";
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
        new MyTask().execute(url);
    }
    //使用asyncTask
    class MyTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String url1 = strings[0];
            try {
                URL u = new URL(url1);
                HttpURLConnection con = (HttpURLConnection) u.openConnection();
                con.setConnectTimeout(5000);
                if(con.getResponseCode()==200){
                    InputStream inputStream = con.getInputStream();
                    String json=inputStreamToString(inputStream);
                    Log.d(TAG, "doInBackground: ++++++"+json);
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
                httpLoadListener.loadSuccess(s);
            }else{
                httpLoadListener.loadError("未加载到数据");
            }
        }
    }
    //转字符串
    private String inputStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader input = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(input);
        StringBuilder builder = new StringBuilder();
        String str="";
        while ((str=reader.readLine())!=null){
            builder.append(str);
        }
        reader.close();
        return builder.toString();
    }

    //设置
    public interface HttpLoadListener{
        void loadSuccess(String json);
        void loadError(String error);
    }

    //监听
    public void setOnHttpLoadListener(HttpLoadListener httpLoadListener){
        this.httpLoadListener=httpLoadListener;
    }
}
