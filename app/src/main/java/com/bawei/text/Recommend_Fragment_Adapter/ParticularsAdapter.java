package com.bawei.text.Recommend_Fragment_Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.text.Bean.PeriodBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/15 20:10
 */

public class ParticularsAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> strings;

    public ParticularsAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> strings) {
        super(fm);
        this.list = list;
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
