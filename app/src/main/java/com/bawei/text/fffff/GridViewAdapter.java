package com.bawei.text.fffff;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.text.Bean.DiscoverBean;
import com.bawei.text.R;
import com.bawei.text.utils.ImageUtils;

import java.util.ArrayList;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/23 8:12
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DiscoverBean.DataBean.InfosBean.TopicsBean> topicsBeen;
    private ViewHolder holder;

    public GridViewAdapter(Context context, ArrayList<DiscoverBean.DataBean.InfosBean.TopicsBean> topicsBeen) {
        this.context = context;
        this.topicsBeen = topicsBeen;
    }

    @Override
    public int getCount() {
        return topicsBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return topicsBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.gridview_adapter, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.dr_02_tuijain_gridview_title);
            holder.nickname = (TextView) convertView.findViewById(R.id.dr_02_tuijain_gridview_nickname);
            holder.pic = (ImageView) convertView.findViewById(R.id.dr_02_tuijain_gridview_pic);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(topicsBeen.get(position).title);
        holder.nickname.setText(topicsBeen.get(position).user.nickname);
        ImageUtils.getImage(topicsBeen.get(position).pic,holder.pic,context);
        return convertView;
    }

    class ViewHolder {
        ImageView pic;
        TextView title;
        TextView nickname;
    }
}
