package com.bawei.text.Recommend_Fragment_Adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bawei.text.ComicCenter_Adpter.RecommendAdapter;
import com.bawei.text.R;
import com.bawei.text.usb.UrlUsb;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/13 20:31
 */

public class Recommend extends Fragment {

    private ViewPager pager;
    private TabLayout tabLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_01, null);
        pager = (ViewPager) view.findViewById(R.id.fra_01_viewpager);
        tabLayout = (TabLayout) view.findViewById(R.id.fra_01_tablayout);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Recommend_Period(UrlUsb.day_01));
        list.add(new Recommend_Period(UrlUsb.day_02));
        list.add(new Recommend_Period(UrlUsb.day_03));
        list.add(new Recommend_Period(UrlUsb.day_04));
        list.add(new Recommend_Period(UrlUsb.day_05));
        list.add(new Recommend_Period(UrlUsb.day_06));
        list.add(new Recommend_Period(UrlUsb.day_07));

        String[] str = new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
        Calendar calendar = Calendar.getInstance();
        int taday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        ArrayList<String> strings = new ArrayList<>();
        strings.clear();
        for (int i = 0; i < 5; i++) {
            if (taday > 6) {
                taday = taday - 7;
            }
            strings.add(str[taday]);
            taday++;
        }
        strings.add("昨天");
        strings.add("今天");
        //设置Tab的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        //fragment的适配器
        RecommendAdapter adapter = new RecommendAdapter(getChildFragmentManager(), list, strings);
        pager.setAdapter(adapter);
        //把TabLayout和ViewPager关联起来
        tabLayout.setupWithViewPager(pager);
        //给Tab设置适配器
        tabLayout.setTabsFromPagerAdapter(adapter);
        pager.setCurrentItem(6);
    }

}
