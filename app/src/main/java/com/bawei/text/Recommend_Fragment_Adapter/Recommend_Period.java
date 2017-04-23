package com.bawei.text.Recommend_Fragment_Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.bawei.text.R;
import com.bawei.text.Bean.PeriodBean;
import com.bawei.text.usb.UrlUsb;
import com.bawei.text.utils.AsyncTaskUilrs;
import com.bawei.text.utils.GsonUtil;
import com.bawei.text.utils.HttpClintUtils;
import com.bawei.text.webview.WebViewUtils;
import com.bawei.xlistviewlibrary.XListView;

import java.util.List;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/15 20:00
 */

@SuppressLint("ValidFragment")
public class Recommend_Period extends Fragment {

    private String url;
    private XListView xListView;
    private List<PeriodBean.DataBean.ComicsBean> list;

    public Recommend_Period(String url) {
        this.url = url;
    }

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
                PeriodBean periodBean = GsonUtil.GsonToBean(s, PeriodBean.class);
                list = periodBean.data.comics;
                xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getContext(), WebViewUtils.class);
                        intent.putExtra("url", list.get(position - 1).url);
                        startActivity(intent);
                    }
                });
                PeriodAdapter adapter = new PeriodAdapter(getActivity(), list);
                xListView.setAdapter(adapter);

            }
        };
        asyncTaskUilrs.execute(url);


    }
}
/*        Handler mHandler = new Handler() {


            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    String s = msg.obj.toString();

                }
            }
        };
        new HttpClintUtils(url, mHandler).start();*/