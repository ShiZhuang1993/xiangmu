package com.bawei.text.ComicCenter_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import com.bawei.text.Discover_Fragment_adapter.Discover;
import com.bawei.text.Discover_Fragment_adapter.Discover_Recommend;
import com.bawei.text.R;
import com.bawei.text.Recommend_Fragment_Adapter.RecommendsAdapter;

import java.util.ArrayList;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/13 20:31
 */

public class ComicCenter_Discover extends Fragment {

    private CheckBox checkBox;
    private ViewPager pager;
    private RadioGroup group;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_02, null);
        pager = (ViewPager) view.findViewById(R.id.two_02_viewpager);
        checkBox = (CheckBox) view.findViewById(R.id.two_nan_nv);
        group = (RadioGroup) view.findViewById(R.id.two_radiogroup);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    checkBox.setText("女生版");
                } else {
                    checkBox.setText("男生版");

                }

            }
        });


        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new Discover_Recommend());
        list.add(new Discover());
        RecommendsAdapter adapter = new RecommendsAdapter(getChildFragmentManager(), list);
        pager.setAdapter(adapter);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.two_tuijian:
                        pager.setCurrentItem(0);
                        break;
                    case R.id.two_fenlie:
                        pager.setCurrentItem(1);
                        break;
                }
            }
        });
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    group.check(R.id.two_tuijian);
                } else {
                    group.check(R.id.two_fenlie);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
