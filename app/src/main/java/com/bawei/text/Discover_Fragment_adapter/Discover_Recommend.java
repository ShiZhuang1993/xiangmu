package com.bawei.text.Discover_Fragment_adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.text.Bean.DiscoverBean;
import com.bawei.text.R;
import com.bawei.text.fffff.XlistAdapter;
import com.bawei.text.usb.UrlUsb;
import com.bawei.text.utils.AsyncTaskUilrs;
import com.bawei.text.utils.GsonUtil;
import com.bawei.text.utils.ImageUtils;
import com.bawei.xlistviewlibrary.XListView;

import java.util.ArrayList;


/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/21 13:12
 */

public class Discover_Recommend extends Fragment {

    private XListView xListView;
    private ViewPager pager;
    private LinearLayout layout;
    private ArrayList<DiscoverBean.DataBean.InfosBean.BannersBean> list;

    private ArrayList<ImageView> dianList;
    private ArrayList<ImageView> imageList;
    private Handler handlers = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int currentItem = pager.getCurrentItem();
            currentItem++;
            pager.setCurrentItem(currentItem);
            handlers.sendEmptyMessageDelayed(0, 2000);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_reconmmend, null);
        xListView = (XListView) view.findViewById(R.id.dr_xlistview);
        //头布局
        View views = LayoutInflater.from(getActivity()).inflate(R.layout.discover_recommend_toubuju, null);
        View viewa = LayoutInflater.from(getActivity()).inflate(R.layout.layout_tu, null);
        pager = (ViewPager) views.findViewById(R.id.dr_02_viewpager);
        layout = (LinearLayout) views.findViewById(R.id.dr_02_linear);
        //把头布局放入list中
        xListView.addHeaderView(views);
        xListView.addHeaderView(viewa);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AsyncTaskUilrs asyncTaskUilrs = new AsyncTaskUilrs() {
            private ArrayList<DiscoverBean.DataBean.InfosBean.TopicsBean> topicsBeen;
            private ArrayList<DiscoverBean.DataBean.InfosBean> infosBean;
            private ArrayList<DiscoverBean.DataBean.InfosBean> titles;

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                DiscoverBean bean = GsonUtil.GsonToBean(s, DiscoverBean.class);
                if (bean != null) {
                    lunBo(bean);
                    infosBean = bean.data.infos;
                    titles = new ArrayList<>();
                    topicsBeen = new ArrayList<>();
                    for (int i = 2; i < infosBean.size(); i++) {
                        titles.add(infosBean.get(i));
                    }
                    for (int j = 0; j < titles.size(); j++) {
                        if (titles.get(j).topics != null) {
                            Log.e("----title----",titles.size()+"");
                            for (int i = 0; i < titles.get(j).topics.size(); i++) {
                                topicsBeen.add(titles.get(j).topics.get(i));
                                Log.e("----topic----",topicsBeen.size()+"");
                            }
                        }
                        Log.e("------topicsBeen------", topicsBeen.size() + "");
                    }
                    XlistAdapter adapter = new XlistAdapter(getActivity(), titles, topicsBeen);
                    xListView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "网络不稳定...", Toast.LENGTH_SHORT).show();
                }

            }

        };
        asyncTaskUilrs.execute(UrlUsb.url);

    }

    private void lunBo(DiscoverBean bean) {
        list = bean.data.infos.get(0).banners;
        imageList = new ArrayList<>();
        dianList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Log.e("---------------", list.toString() + "");
            ImageView image = new ImageView(getActivity());
            String pic = list.get(i).pic;
            ImageUtils.getImage(pic, image, getActivity());
            image.setScaleType(ImageView.ScaleType.FIT_XY);
            imageList.add(image);
            ImageView dian = new ImageView(getActivity());
            dian.setImageResource(R.drawable.lunbo);
            dian.setPadding(5, 0, 5, 0);
            dianList.add(dian);
            layout.addView(dian);
        }
        dianList.get(0).setSelected(true);
        handlers.sendEmptyMessageDelayed(0, 2000);
        Discover_rec_Adapter adapter = new Discover_rec_Adapter(getActivity(), imageList);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                position = position % imageList.size();
                for (int i = 0; i < dianList.size(); i++) {
                    dianList.get(i).setSelected(false);
                }
                dianList.get(position).setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
