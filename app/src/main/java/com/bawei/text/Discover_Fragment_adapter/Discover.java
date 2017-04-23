package com.bawei.text.Discover_Fragment_adapter;

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
import com.bawei.text.Recommend_Fragment_Adapter.Recommend_Period;
import com.bawei.text.usb.UrlUsb;

import java.util.ArrayList;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/23 18:25
 */

public class Discover extends Fragment {

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

        String[] str = new String[]{"全部", "恋爱", "灵异", "古风", "爆笑", "奇幻", "校园", "都市", "少年", "治愈", "完结"};
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            strings.add(str[i]);
        }


        //动态添加
        ArrayList<Fragment> list = new ArrayList<>();
        String[] strs = new String[]{UrlUsb.fenlei, UrlUsb.fenlei_01, UrlUsb.fenlei_02, UrlUsb.fenlei_03, UrlUsb.fenlei_04, UrlUsb.fenlei_05, UrlUsb.fenlei_06,
                UrlUsb.fenlei_07, UrlUsb.fenlei_08, UrlUsb.fenlei_09, UrlUsb.fenlei_10};
        for (int i = 0; i < strs.length; i++) {
            Fragment f = Discover_Classify.newInstance(strs[i]);
            list.add(f);
        }


        //设置Tab的模式
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //fragment的适配器
        RecommendAdapter adapter = new RecommendAdapter(getChildFragmentManager(), list, strings);
        pager.setAdapter(adapter);
        //把TabLayout和ViewPager关联起来
        tabLayout.setupWithViewPager(pager);
        //给Tab设置适配器
        tabLayout.setTabsFromPagerAdapter(adapter);

    }
}
