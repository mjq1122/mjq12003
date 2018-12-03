package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwei.week01text.R;

import java.util.List;

import beans.NewsBean;

/**
 * Created by Lenovo on 2018/11/5.
 */

public class ListsAdapter extends BaseAdapter {
    private Context context;
    private List<NewsBean.NewslistBean> list;

    public ListsAdapter(Context context, List<NewsBean.NewslistBean> list) {
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
            convertView=View.inflate(context,R.layout.item_layout,null);
            holder=new ViewHolder();
            holder.test_ctime=convertView.findViewById(R.id.test_ctime);
            holder.test_title=convertView.findViewById(R.id.test_title);
            holder.test_description=convertView.findViewById(R.id.test_description);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.test_ctime.setText(list.get(position).getCtime());
        holder.test_title.setText(list.get(position).getTitle());
        holder.test_description.setText(list.get(position).getDescription());
        return convertView;
    }
    class ViewHolder{
        TextView test_ctime,test_title,test_description;
    }
}
