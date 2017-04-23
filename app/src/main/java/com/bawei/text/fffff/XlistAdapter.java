package com.bawei.text.fffff;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.bawei.text.Bean.DiscoverBean;
import com.bawei.text.R;

import java.util.ArrayList;


/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/22 14:59
 */

public class XlistAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DiscoverBean.DataBean.InfosBean> titles;
    private ArrayList<DiscoverBean.DataBean.InfosBean.TopicsBean> topicsBeen;
    private ViewHolder holder;

    public XlistAdapter(Context context, ArrayList<DiscoverBean.DataBean.InfosBean> titles, ArrayList<DiscoverBean.DataBean.InfosBean.TopicsBean> topicsBeen) {
        this.context = context;
        this.titles = titles;
        this.topicsBeen = topicsBeen;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.xlist_adapter, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.dr_02_tuijian_title);
            holder.gridView = (GridView) convertView.findViewById(R.id.dr_02_tuijain_gridview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(titles.get(position).title);
        GridViewAdapter adapter = new GridViewAdapter(context,topicsBeen);
        holder.gridView.setAdapter(adapter);
        return convertView;
    }

    class ViewHolder {
        TextView title;
        GridView gridView;
    }

}
