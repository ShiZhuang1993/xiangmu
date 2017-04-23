package com.bawei.text.Recommend_Fragment_Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.bawei.text.R;
import com.bawei.text.usb.UrlUsb;
import com.bawei.text.utils.ImageUtils;

import java.util.ArrayList;

public class PeriodParticulars extends AppCompatActivity {

    private ImageView imageView;
    private ViewPager pager;
    private ArrayList<String> strings;
    private ArrayList<Fragment> fragmentList;
    private TextView titlea;
    private TextView title;
    private ArrayList<String> titleList;
    private ArrayList<String> titlesList;
    private XTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_period_particulars);
        initView();
        initData();
    }

    private void initView() {
        Button guanzhu = (Button) findViewById(R.id.particulars_cover_guanzhu);
        ImageView fanhui = (ImageView) findViewById(R.id.particulars_cover_fanhui);
        titlea = (TextView) findViewById(R.id.particulars_cover_titlea);
        title = (TextView) findViewById(R.id.particulars_cover_title);
        TextView juxuyuedu = (TextView) findViewById(R.id.particulars_cover_jixuyuedu);
        imageView = (ImageView) findViewById(R.id.particulars_cover_image);
        tabLayout = (XTabLayout) findViewById(R.id.particulars_cover_tablayout);
        pager = (ViewPager) findViewById(R.id.particulars_cover_viewpager);

    }

    private void initData() {
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        titlesList = new ArrayList<>();
        strings = new ArrayList<>();
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        String titled = intent.getStringExtra("title");
        String titlew = intent.getStringExtra("titles");
        ImageUtils.getImage(image, imageView, PeriodParticulars.this);
        titlea.setText(titlew);
        title.setText(titled);
        //tablayout设置选项卡
        String[] str = new String[]{"详情", "选集"};
        for (int i = 0; i < str.length; i++) {
            strings.add(str[i]);
            ParticularsFragment fragment = new ParticularsFragment();
            fragmentList.add(fragment);
            //bundle把url传给fragment
            Bundle bundle = new Bundle();
            bundle.putString("url", UrlUsb.day_01);
            fragment.setArguments(bundle);
        }
        //设置TABlayout的模式
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        ParticularsAdapter adapter = new ParticularsAdapter(getSupportFragmentManager(), fragmentList, strings);
        pager.setAdapter(adapter);
        //把TABlayout和iewpager关联起来
        tabLayout.setupWithViewPager(pager);
        //给TABlayout设置适配器
        tabLayout.setTabsFromPagerAdapter(adapter);

    }


}

