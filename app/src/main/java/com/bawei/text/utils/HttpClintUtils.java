package com.bawei.text.utils;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * autour: 史壮壮
 * date: 2017/3/15 13:32
 * update: 2017/3/15
 */

public class HttpClintUtils extends Thread {
    public String urls;
    public String result = "";
    public Handler mHandler;

    public HttpClintUtils(String url, Handler mHandler) {
        this.urls = url;
        this.mHandler = mHandler;
    }

    @Override
    public void run() {
        super.run();
        try {
            String getDate = DoGet(urls);
            if (getDate != null) {
                Message msg = new Message();
                msg.what = 1;
                msg.obj = getDate;
                mHandler.sendMessage(msg);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //get请求
    public String DoGet(String url) throws MalformedURLException {
        HttpURLConnection conn = null; //初始化HTTpURLconnection
        try {
            URL mUrl = new URL(url);
            //1.得到HttpURLConnection实例化对象
            conn = (HttpURLConnection) mUrl.openConnection();
            //2.设置请求信息（请求方式）
            //设置请求方式和响应时间
            conn.setRequestMethod("GET");
            conn.setRequestProperty("encoding", "UTF-8"); //可以指定编码
            conn.setConnectTimeout(5000);
            //不使用缓存
            conn.setUseCaches(false);
            //3.读取相应
            if (conn.getResponseCode() == 200) {
                //先将服务器得到的流对象 包装 存入缓冲区，忽略了正在缓冲时间
                InputStream inputStream = conn.getInputStream();
                byte[] b = new byte[1024];
                int len = 0;
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                while ((len = inputStream.read(b)) != -1) {
                    stream.write(b, 0, len);
                }
                result = stream.toString();
            } else {
                System.out.println("请求失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            if (conn != null) {
                //关闭连接 即设置 http.keepAlive = false;
                conn.disconnect();
            }
        }
        return result;
    }
}
