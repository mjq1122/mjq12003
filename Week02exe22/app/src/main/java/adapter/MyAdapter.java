package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.week02exe22.R;

import java.util.List;

import beans.NewsBean;

/**
 * Created by Lenovo on 2018/11/11.
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
        ViewHodler hodler;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item_layout,null);
            hodler=new ViewHodler();
            hodler.text_title=convertView.findViewById(R.id.text_title);
            hodler.text_dec=convertView.findViewById(R.id.text_dec);
            hodler.img_pic=convertView.findViewById(R.id.img_pic);
            convertView.setTag(hodler);
        }else{
            hodler= (ViewHodler) convertView.getTag();
        }
        hodler.text_title.setText(list.get(position).getTitle());
        hodler.text_dec.setText(list.get(position).getDescription());
        Glide.with(context).load(list.get(position).getPicUrl()).into(hodler.img_pic);
        return convertView;
    }
    class ViewHodler{
        TextView text_title,text_dec;
        ImageView img_pic;
    }
}
