package com.bawei.text.Recommend_Fragment_Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/17 19:20
 */

public class RecommendsAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;

    public RecommendsAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
