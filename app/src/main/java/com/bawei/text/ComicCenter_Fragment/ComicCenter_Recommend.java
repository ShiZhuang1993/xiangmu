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
import com.bawei.text.Recommend_Fragment_Adapter.Recommend_Attention;
import com.bawei.text.Recommend_Fragment_Adapter.Recommend;

import java.util.ArrayList;

public class ComicCenter_Recommend extends Fragment {

    private ViewPager pager;
    private RadioGroup group;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comiccenter_recommend, null);
        pager = (ViewPager) view.findViewById(R.id.recommend_viewpager);
        group = (RadioGroup) view.findViewById(R.id.one_radiogrup);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Recommend_Attention());
        list.add(new Recommend());
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    group.check(R.id.one_guanzhu);
                } else {
                    group.check(R.id.one_remen);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        RecommendsAdapter adapter = new RecommendsAdapter(getChildFragmentManager(), list);
        pager.setAdapter(adapter);
        pager.setCurrentItem(1);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.one_guanzhu:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.one_remen:
                        pager.setCurrentItem(1);
                        break;
                }
            }
        });
    }
}
