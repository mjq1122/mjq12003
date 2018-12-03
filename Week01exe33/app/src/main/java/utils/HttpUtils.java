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
 * 1.单例模式
 * 2.
 */

public class HttpUtils {
    private static final String TAG = "HttpUtils======";
    private static HttpUtils httpUtils=null;
    private HttpLoadListener httpLoadListener;

    private HttpUtils(){};
    public static HttpUtils getHttpUtils(){
        if(httpUtils==null){
            httpUtils=new HttpUtils();
        }
        return httpUtils;
    }
    //get
    public void get(String url){
        new MyTask().execute(url);
    }

    class MyTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            try {
                URL url1 = new URL(url);
                HttpURLConnection con = (HttpURLConnection) url1.openConnection();
                con.setConnectTimeout(5000);
                if(con.getResponseCode()==200){
                    InputStream inputStream = con.getInputStream();
                    String json=inputStreamToString(inputStream);
                    Log.d(TAG, "json11111"+json);
                    return json;
                }else{
                    httpLoadListener.loadError("网络加载失败");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d(TAG, "onPostExecute: ======"+s);
            httpLoadListener.loadSuccess(s);
        }
    }
    public interface HttpLoadListener{
        void loadSuccess(String json);
        void loadError(String error);
    }
    public void setOnHttpLoadListener(HttpLoadListener httpLoadListener){
        this.httpLoadListener=httpLoadListener;
    }
    //流转字符串
    public static String inputStreamToString(InputStream inputStream) throws IOException {
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
}
