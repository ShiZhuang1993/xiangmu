package com.bawei.text.Discover_Fragment_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.text.Bean.ClassifyBean;
import com.bawei.text.R;
import com.bawei.text.utils.ImageUtils;

import java.util.ArrayList;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/23 18:38
 */

public class ClassifyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ClassifyBean.DataBean.TopicsBean> list;
    private ViewHolder holder;

    public ClassifyAdapter(Context context, ArrayList<ClassifyBean.DataBean.TopicsBean> list) {
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
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.classify_list, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.classify_list_title);
            holder.nickname = (TextView) convertView.findViewById(R.id.classify_list_nickname);
            holder.likes_count = (TextView) convertView.findViewById(R.id.classify_list_likes_count);
            holder.comments_count = (TextView) convertView.findViewById(R.id.classify_llist_comments_count);
            holder.cover_image_url = (ImageView) convertView.findViewById(R.id.classify_list_image);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(list.get(position).title);
        holder.nickname.setText(list.get(position).user.nickname);
        holder.likes_count.setText(list.get(position).likes_count + "");
        holder.comments_count.setText(list.get(position).comments_count + "");
        ImageUtils.getImage(list.get(position).cover_image_url, holder.cover_image_url, context);
        return convertView;
    }

    class ViewHolder {
        ImageView cover_image_url;
        TextView title;
        TextView nickname;
        TextView likes_count;
        TextView comments_count;

    }

}
