package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.monthexe11.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import app.MyApp;
import beans.NewsBean;

/**
 * Created by Lenovo on 2018/11/22.
 */

public class NewsAdapter extends BaseAdapter {
    private Context context;
    private List<NewsBean.DataBean> list;

    public NewsAdapter(Context context, List<NewsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type){
            case 0:
                ViewHolder1 holder1;
                if(convertView==null){
                    convertView=View.inflate(context,R.layout.item1_layout,null);
                    holder1=new ViewHolder1();
                    holder1.text1_title=convertView.findViewById(R.id.text1_title);
                    holder1.img1_thumbnail_pic_s=convertView.findViewById(R.id.img1_thumbnail_pic_s);
                    convertView.setTag(holder1);
                }else{
                    holder1= (ViewHolder1) convertView.getTag();
                }
                holder1.text1_title.setText(list.get(position).getTitle());
                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder1.img1_thumbnail_pic_s, MyApp.getOptions());
                break;
            case 1:
                ViewHolder2 holder2;
                if(convertView==null){
                    convertView=View.inflate(context,R.layout.item2_layout,null);
                    holder2=new ViewHolder2();
                    holder2.text2_title=convertView.findViewById(R.id.text2_title);
                    holder2.img2_thumbnail_pic_s=convertView.findViewById(R.id.img2_thumbnail_pic_s);
                    holder2.img2_thumbnail_pic_s02=convertView.findViewById(R.id.img2_thumbnail_pic_s02);
                    holder2.img2_thumbnail_pic_s03=convertView.findViewById(R.id.img2_thumbnail_pic_s03);
                    convertView.setTag(holder2);
                }else{
                    holder2= (ViewHolder2) convertView.getTag();
                }
                holder2.text2_title.setText(list.get(position).getTitle());
                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder2.img2_thumbnail_pic_s, MyApp.getOptions());
                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s02(),holder2.img2_thumbnail_pic_s02, MyApp.getOptions());
                ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s03(),holder2.img2_thumbnail_pic_s03, MyApp.getOptions());
                break;
        }
        return convertView;
    }
    class ViewHolder1{
        TextView text1_title;
        ImageView img1_thumbnail_pic_s;
    }
    class ViewHolder2{
        TextView text2_title;
        ImageView img2_thumbnail_pic_s,img2_thumbnail_pic_s02,img2_thumbnail_pic_s03;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int type=0;
        if(position%2==0){
            type=1;
        }
        return type;
    }
}
