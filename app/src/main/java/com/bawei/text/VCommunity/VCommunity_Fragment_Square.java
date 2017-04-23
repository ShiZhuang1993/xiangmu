package com.bawei.text.VCommunity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.xtablayout.XTabLayout;

import com.bawei.text.R;
import com.bawei.text.Recommend_Fragment_Adapter.ParticularsAdapter;
import com.bawei.text.usb.UrlUsb;

import java.util.ArrayList;

/**
 * 类用途:
 * 作者:崔涵淞
 * 时间: 2017/3/28.
 */

public class VCommunity_Fragment_Square extends Fragment {

    private View view;
    private ViewPager pager;

    private LayoutInflater layoutInflater;
    private XTabLayout tab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.vcommunity_fragment_square, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        layoutInflater = LayoutInflater.from(getActivity());
        ArrayList<Fragment> listFragment = new ArrayList<>();
        ArrayList<String> listText = new ArrayList<>();
        listFragment.add(new VCommunity_Square_Fragment(UrlUsb.remen));
        listFragment.add(new VCommunity_Square_Fragment(UrlUsb.zuixin));
        String[] text = new String[]{"热门", "最新"};
        for (int i = 0; i < text.length; i++) {
            listText.add(text[i]);
        }
        tab.setTabMode(TabLayout.MODE_FIXED);
        ParticularsAdapter adapter = new ParticularsAdapter(getChildFragmentManager(), listFragment, listText);
        pager.setAdapter(adapter);
        tab.setupWithViewPager(pager);
        tab.setTabsFromPagerAdapter(adapter);
        pager.setCurrentItem(0);
    }

    private void initView() {
        tab = (XTabLayout) view.findViewById(R.id.vcommunity_square_tablayout);
        pager = (ViewPager) view.findViewById(R.id.vcommunity_square_viewpager);
    }
}
