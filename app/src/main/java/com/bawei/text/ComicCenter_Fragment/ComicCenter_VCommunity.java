package com.bawei.text.ComicCenter_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


import com.bawei.text.R;
import com.bawei.text.Recommend_Fragment_Adapter.RecommendsAdapter;
import com.bawei.text.VCommunity.VCommunity_Fragment_Attention;
import com.bawei.text.VCommunity.VCommunity_Fragment_Square;

import java.util.ArrayList;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/13 20:31
 */

public class ComicCenter_VCommunity extends Fragment {

    private ViewPager mPager;
    private RadioGroup group;
    private ArrayList<Fragment> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_03, null);
        mPager = (ViewPager) view.findViewById(R.id.fragement_03_viewpager);
        group = (RadioGroup) view.findViewById(R.id.three_radiogrup);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mList = new ArrayList<>();
        mList.add(new VCommunity_Fragment_Attention());
        mList.add(new VCommunity_Fragment_Square());
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    group.check(R.id.three_guanzhu);
                } else {
                    group.check(R.id.three_guangcheng);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        RecommendsAdapter adapter = new RecommendsAdapter(getChildFragmentManager(), mList);
        mPager.setAdapter(adapter);
        mPager.setCurrentItem(1);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.three_guanzhu:
                        mPager.setCurrentItem(0);
                        break;
                    case R.id.three_guangcheng:
                        mPager.setCurrentItem(1);
                        break;
                }
            }
        });
    }
}
