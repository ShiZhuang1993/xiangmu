package com.bawei.text.VCommunity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.text.Bean.VCommunity_SquareBean;
import com.bawei.text.R;
import com.bawei.xlistviewlibrary.XListView;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;


public class VCommunity_Square_Fragment extends Fragment {
    private String url;
    private View view;
    private XListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.vcommunity_square_fragment, null);
        return view;
    }
    public VCommunity_Square_Fragment(String url){
        this.url = url;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(getActivity(), url, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getActivity(), "失败的请求", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Gson gson = new Gson();
                VCommunity_SquareBean json = gson.fromJson(responseString, VCommunity_SquareBean.class);
                List<VCommunity_SquareBean.DataBean.FeedsBean> feeds = json.data.feeds;
                VCommunity_SquareAdapter adapter = new VCommunity_SquareAdapter(getActivity(),feeds );
                listView.setAdapter(adapter);
            }

        });
    }

    private void initView() {
        listView = (XListView) view.findViewById(R.id.square_fragment_xlistview);
    }
}
