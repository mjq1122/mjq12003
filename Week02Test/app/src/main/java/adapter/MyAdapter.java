package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.week02test.R;

import java.util.List;

import beans.NewsBean;

/**
 * Created by Lenovo on 2018/11/12.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<NewsBean.NewslistBean> list;

    public MyAdapter(Context context, List<NewsBean.NewslistBean> list) {
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
        switch (type) {
            case 0:
                ViewHodler1 hodler1;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item1_layout, null);
                    hodler1 = new ViewHodler1();
                    hodler1.text1_title = convertView.findViewById(R.id.text1_title);
                    hodler1.text1_ctime = convertView.findViewById(R.id.text1_ctime);
                    convertView.setTag(hodler1);
                } else {
                    hodler1 = (ViewHodler1) convertView.getTag();
                }
                hodler1.text1_title.setText(list.get(position).getTitle());
                hodler1.text1_ctime.setText(list.get(position).getCtime());
                break;
            case 1:
                ViewHodler2 hodler2;
                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.item2_layout, null);
                    hodler2 = new ViewHodler2();
                    hodler2.text2_title = convertView.findViewById(R.id.text2_title);
                    hodler2.text2_ctime = convertView.findViewById(R.id.text2_ctime);
                    hodler2.img2_picUrl = convertView.findViewById(R.id.img2_picUrl);
                    convertView.setTag(hodler2);
                } else {
                    hodler2 = (ViewHodler2) convertView.getTag();
                }
                hodler2.text2_title.setText(list.get(position).getTitle());
                hodler2.text2_ctime.setText(list.get(position).getCtime());
                Glide.with(context).load(list.get(position).getPicUrl()).into(hodler2.img2_picUrl);
                break;
        }
        return convertView;
    }

    //创建布局文件
    class ViewHodler1 {
        TextView text1_title, text1_ctime;
    }

    class ViewHodler2 {
        TextView text2_title, text2_ctime;
        ImageView img2_picUrl;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (position % 2 == 0) {
            type = 1;
        }
        return type;
    }


}
