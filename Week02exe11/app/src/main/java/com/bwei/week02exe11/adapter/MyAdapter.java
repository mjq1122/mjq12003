package com.bwei.week02exe11.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.week02exe11.R;
import com.bwei.week02exe11.beans.NewsBean;

import java.util.List;

/**
 * Created by Lenovo on 2018/11/9.
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
        ViewHolder holder;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item_layout,null);
            holder=new ViewHolder();
            holder.text_title=convertView.findViewById(R.id.text_title);
            holder.text_ctime=convertView.findViewById(R.id.text_ctime);
            holder.img_picUrl=convertView.findViewById(R.id.img_picUrl);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.text_title.setText(list.get(position).getTitle());
        holder.text_ctime.setText(list.get(position).getCtime());
        Glide.with(context).load(list.get(position).getPicUrl()).into(holder.img_picUrl);
        return convertView;
    }
    class ViewHolder{
        TextView text_title,text_ctime;
        ImageView img_picUrl;
    }
}
