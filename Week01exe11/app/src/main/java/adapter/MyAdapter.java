package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwei.week01exe11.R;

import java.util.List;

import beans.NewsBean;

/**
 * Created by Lenovo on 2018/11/4.
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
            holder.text_ctime=convertView.findViewById(R.id.text_ctime);
            holder.text_title=convertView.findViewById(R.id.text_title);
            holder.text_description=convertView.findViewById(R.id.text_description);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.text_ctime.setText(list.get(position).getCtime());
        holder.text_title.setText(list.get(position).getTitle());
        holder.text_description.setText(list.get(position).getDescription());
        return convertView;
    }
    class ViewHolder{
        TextView text_ctime,text_title,text_description;
    }
}
