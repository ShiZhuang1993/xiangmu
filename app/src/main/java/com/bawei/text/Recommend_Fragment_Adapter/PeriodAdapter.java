package com.bawei.text.Recommend_Fragment_Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.text.R;
import com.bawei.text.Bean.PeriodBean;
import com.bawei.text.utils.ImageUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/16 13:39
 */

public class PeriodAdapter extends BaseAdapter {
    private Context context;
    private List<PeriodBean.DataBean.ComicsBean> list;
    private ViewHolder holder;

    public PeriodAdapter(Context context, List<PeriodBean.DataBean.ComicsBean> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.period_list, null);
            holder = new ViewHolder();
            holder.label_text = (TextView) convertView.findViewById(R.id.period_label_text);
            holder.title = (TextView) convertView.findViewById(R.id.period_title);
            holder.titles = (TextView) convertView.findViewById(R.id.period_titles);
            holder.likes_count = (TextView) convertView.findViewById(R.id.period_likes_count);
            holder.comments_count = (TextView) convertView.findViewById(R.id.period_comments_count);
            holder.cover_image_url = (ImageView) convertView.findViewById(R.id.period_cover_image_url);
            LinearLayout layout = (LinearLayout) convertView.findViewById(R.id.period_linearlayout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PeriodParticulars.class);
                    intent.putExtra("image", list.get(position).topic.cover_image_url);
                    intent.putExtra("title", list.get(position).topic.title);
                    intent.putExtra("titles", list.get(position).title);
                    context.startActivity(intent);
                }
            });
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.label_text.setText(list.get(position).label_text);
        holder.label_text.setTextColor(Color.parseColor(list.get(position).label_text_color));
        //实现字体圆形背景的代码
        GradientDrawable background = (GradientDrawable) holder.label_text.getBackground();
        background.setColor(Color.parseColor(list.get(position).label_color));

        holder.title.setText(list.get(position).title);
        holder.titles.setText(list.get(position).title);
        holder.likes_count.setText(list.get(position).likes_count + "");
        holder.comments_count.setText(list.get(position).comments_count + "");
        ImageUtils.getImage(list.get(position).cover_image_url, holder.cover_image_url, context);
        return convertView;
    }

    class ViewHolder {
        TextView label_text;
        TextView title;
        ImageView cover_image_url;
        TextView titles;
        TextView likes_count;
        TextView comments_count;

    }

}
