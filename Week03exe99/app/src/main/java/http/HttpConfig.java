package http;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2018/11/16.
 */

public class HttpConfig {
    public static List<String> leftData=new ArrayList<>();
    public static List<String> getleftData(){
        for (int i = 0; i <4 ; i++) {
            leftData.add("左侧数据"+i);
        }
        return leftData;
    }
    //    接口
    public static String adurl = "http://www.xieast.com/api/banner.php";
    public static String listurl = "http://www.xieast.com/api/news/news.php?page=";
}
