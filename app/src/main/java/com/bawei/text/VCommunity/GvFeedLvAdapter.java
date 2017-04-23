package com.bawei.text.VCommunity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.bawei.text.R;
import com.bawei.text.utils.ImageUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


public class GvFeedLvAdapter extends BaseAdapter {
    public static String ImageBase = "http://f1.kkmh.com/";
    private List<String> list;
    private Context context;

    public GvFeedLvAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
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
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_gv_feed_item, null);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.iv_item_gv_feed);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageUtils.getImage(ImageBase + list.get(position), holder.mImageView, context);
        return convertView;
    }

    private class ViewHolder {
        ImageView mImageView;
    }
}
