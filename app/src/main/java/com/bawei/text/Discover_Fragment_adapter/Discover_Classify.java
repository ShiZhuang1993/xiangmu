package com.bawei.text.Discover_Fragment_adapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.text.Bean.ClassifyBean;
import com.bawei.text.Bean.PeriodBean;
import com.bawei.text.R;
import com.bawei.text.Recommend_Fragment_Adapter.PeriodAdapter;
import com.bawei.text.utils.AsyncTaskUilrs;
import com.bawei.text.utils.GsonUtil;
import com.bawei.xlistviewlibrary.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/23 18:36
 */
@SuppressLint("ValidFragment")
public class Discover_Classify extends Fragment {

    private XListView xListView;
    private ArrayList<ClassifyBean.DataBean.TopicsBean> list;
    private String url;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_period, null);
        xListView = (XListView) view.findViewById(R.id.fra_period);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //调用
        Bundle bundle = getArguments();
        url = bundle.getString("url");

        xianshi();
        xListView.setPullRefreshEnable(true);
        //xListView.setPullLoadEnable(true);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                xListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();
                        xianshi();
                        xListView.stopRefresh();
                        Toast.makeText(getActivity(), "加载完毕", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);

            }

            @Override
            public void onLoadMore() {
            }
        });
    }

    private void xianshi() {

        AsyncTaskUilrs asyncTaskUilrs = new AsyncTaskUilrs() {
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.e("----------------", s);
                ClassifyBean classifyBean = GsonUtil.GsonToBean(s, ClassifyBean.class);
                list = classifyBean.data.topics;
                ClassifyAdapter adapter = new ClassifyAdapter(getActivity(),list);
                 xListView.setAdapter(adapter);

            }
        };
        asyncTaskUilrs.execute(url);


    }

    //传值
    public static Discover_Classify newInstance(String address) {
        Bundle bundle = new Bundle();
        bundle.putString("url", address);
        Discover_Classify hot_week = new Discover_Classify();
        hot_week.setArguments(bundle);
        return hot_week;
    }
}
