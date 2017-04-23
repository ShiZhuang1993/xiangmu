package com.bawei.text.Discover_Fragment_adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/21 19:09
 */

public class Discover_rec_Adapter extends PagerAdapter {
    private Context context;
    private ArrayList<ImageView> imageList;

    public Discover_rec_Adapter(Context context, ArrayList<ImageView> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % imageList.size();
        container.addView(imageList.get(position));
        return imageList.get(position);
    }
}
