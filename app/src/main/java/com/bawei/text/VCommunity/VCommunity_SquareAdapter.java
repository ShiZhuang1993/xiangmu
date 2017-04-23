package com.bawei.text.VCommunity;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.text.Bean.VCommunity_SquareBean;
import com.bawei.text.R;
import com.bawei.text.utils.DateUtils;
import com.bawei.text.utils.ImageUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


public class VCommunity_SquareAdapter extends BaseAdapter {
    private Context context;
    private List<VCommunity_SquareBean.DataBean.FeedsBean> list;

    public VCommunity_SquareAdapter(Context context, List<VCommunity_SquareBean.DataBean.FeedsBean> list) {
        this.context = context;
        this.list = list;
    }

    private static final int TYPE_00 = 0;
    private static final int TYPE_01 = 1;
    private static final int TYPE_02 = 2;
    private static final int TYPE_03 = 3;

    @Override
    public int getItemViewType(int position) {
        int size =  list.get(position).content.images.size();
        if (size == 0) {
            return TYPE_00;
        } else if (size == 1) {
            return TYPE_01;
        } else if (size == 4) {
            return TYPE_02;
        } else {
            return TYPE_03;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 4;
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
        switch (getItemViewType(position)) {
            case TYPE_00:
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(context, R.layout.item_lv_feed_pic0, null);
                    holder.iv_author = (ImageView) convertView.findViewById(R.id.iv_item_feed_0);
                    holder.tv_author = (TextView) convertView.findViewById(R.id.tv_item_feed_name_0);
                    holder.content = (TextView) convertView.findViewById(R.id.tv_item_content_feed_0);
                    holder.tv_creat_time = (TextView) convertView.findViewById(R.id.tv_time_item_feed_0);
                    holder.likes = (TextView) convertView.findViewById(R.id.ck_likes_item_feed_0);
                    holder.conments = (TextView) convertView.findViewById(R.id.ck_comments_item_feed_0);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                ImageUtils.getImage(list.get(position).user.avatar_url, holder.iv_author, context);
                holder.tv_author.setText(list.get(position).user.nickname);
                holder.content.setText(list.get(position).content.text);
                holder.tv_creat_time.setText(DateUtils.getDateToString(list.get(position).updated_at) + "");
                holder.likes.setText(list.get(position).likes_count + "");
                holder.conments.setText(list.get(position).comments_count + "");
                break;
            case TYPE_01:
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(context, R.layout.item_lv_feed_pic1, null);
                    holder.iv_author = (ImageView) convertView.findViewById(R.id.iv_item_feed_1);
                    holder.tv_author = (TextView) convertView.findViewById(R.id.tv_item_feed_name_1);
                    holder.content = (TextView) convertView.findViewById(R.id.tv_item_content_feed_1);
                    holder.tv_creat_time = (TextView) convertView.findViewById(R.id.tv_time_item_feed_1);
                    holder.likes = (TextView) convertView.findViewById(R.id.ck_likes_item_feed_1);
                    holder.conments = (TextView) convertView.findViewById(R.id.ck_comments_item_feed_1);
                    holder.one_iv = (ImageView) convertView.findViewById(R.id.iv_item_feed_1);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                ImageUtils.getImage(list.get(position).user.avatar_url, holder.iv_author, context);
                ImageUtils.getImage(list.get(position).content.images.get(0), holder.one_iv, context);
                holder.tv_author.setText(list.get(position).user.nickname);
                holder.content.setText(list.get(position).content.text);
                holder.tv_creat_time.setText(DateUtils.getDateToString(list.get(position).updated_at) + "");
                holder.likes.setText(list.get(position).likes_count + "");
                holder.conments.setText(list.get(position).comments_count + "");
                break;
            case TYPE_02:
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(context, R.layout.item_lv_feed_pic2, null);
                    holder.iv_author = (ImageView) convertView.findViewById(R.id.iv_author_item_feed_2);
                    holder.tv_author = (TextView) convertView.findViewById(R.id.tv_item_feed_name_2);
                    holder.content = (TextView) convertView.findViewById(R.id.tv_item_content_feed_2);
                    holder.tv_creat_time = (TextView) convertView.findViewById(R.id.tv_time_item_feed_2);
                    holder.likes = (TextView) convertView.findViewById(R.id.ck_likes_item_feed_2);
                    holder.conments = (TextView) convertView.findViewById(R.id.ck_comments_item_feed_2);
                    holder.item_01 = (ImageView) convertView.findViewById(R.id.iv_item_feed_2_01);
                    holder.item_02 = (ImageView) convertView.findViewById(R.id.iv_item_feed_2_02);
                    holder.item_03 = (ImageView) convertView.findViewById(R.id.iv_item_feed_2_03);
                    holder.item_04 = (ImageView) convertView.findViewById(R.id.iv_item_feed_2_04);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                ImageUtils.getImage(list.get(position).user.avatar_url, holder.iv_author, context);
                holder.tv_author.setText(list.get(position).user.nickname);
                holder.content.setText(list.get(position).content.text);
                holder.tv_creat_time.setText(DateUtils.getDateToString(list.get(position).updated_at) + "");
                holder.likes.setText(list.get(position).likes_count + "");
                holder.conments.setText(list.get(position).comments_count + "");
                ImageUtils.getImage(list.get(position).content.images.get(0), holder.item_01, context);
                ImageUtils.getImage(list.get(position).content.images.get(1), holder.item_02, context);
                ImageUtils.getImage(list.get(position).content.images.get(2), holder.item_03, context);
                ImageUtils.getImage(list.get(position).content.images.get(3), holder.item_04, context);
                break;
            case TYPE_03:
                if (convertView == null) {
                    holder = new ViewHolder();
                    convertView = View.inflate(context, R.layout.item_lv_feed_pic3, null);
                    holder.iv_author = (ImageView) convertView.findViewById(R.id.iv_author_item_feed_3);
                    holder.tv_author = (TextView) convertView.findViewById(R.id.tv_item_feed_name_3);
                    holder.content = (TextView) convertView.findViewById(R.id.tv_item_content_feed_3);
                    holder.tv_creat_time = (TextView) convertView.findViewById(R.id.tv_time_item_feed_3);
                    holder.likes = (TextView) convertView.findViewById(R.id.ck_likes_item_feed_3);
                    holder.conments = (TextView) convertView.findViewById(R.id.ck_comments_item_feed_3);
                    holder.gridview = (GridView) convertView.findViewById(R.id.gv_item_feed_3);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                ImageUtils.getImage(list.get(position).user.avatar_url, holder.iv_author, context);
                holder.tv_author.setText(list.get(position).user.nickname);
                holder.content.setText(list.get(position).content.text);
                holder.tv_creat_time.setText(DateUtils.getDateToString(list.get(position).updated_at) + "");
                holder.likes.setText(list.get(position).likes_count + "");
                holder.conments.setText(list.get(position).comments_count + "");
                GvFeedLvAdapter adapter = new GvFeedLvAdapter(list.get(position).content.images, context);
                holder.gridview.setAdapter(adapter);
                break;
        }
        return convertView;
    }


    private class ViewHolder {
        ImageView one_iv;
        ImageView iv_author;
        TextView tv_author;
        ImageView attention;
        TextView content;
        GridView gridview;
        TextView tv_creat_time;
        TextView likes;
        TextView conments;
        ImageView item_01;
        ImageView item_02;
        ImageView item_03;
        ImageView item_04;
    }
}
