package com.bawei.text.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/22 15:16
 */

public class HttpIOUtils {
    protected static final String CHARSET = "UTF-8";
    protected static final int readTimeout = 5 * 1000;
    protected static final int connectTimeout = 5 * 1000;

    //单例模式
    private HttpIOUtils() {
    }

    private static HttpIOUtils httpTransfer;

    public static HttpIOUtils getInstance() {
        if (httpTransfer == null) {
            synchronized (HttpIOUtils.class) {
                if (httpTransfer == null) {
                    httpTransfer = new HttpIOUtils();
                }
            }
        }
        return httpTransfer;
    }


    //获取HttpURLConnection
    public HttpURLConnection createConnection(String urls) throws Exception {
        URL url = new URL(urls);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        return connection;
    }

    //获取流
    public InputStream getInputStream(String urls) throws Exception {
        HttpURLConnection connection = createConnection(urls);
        connection.setRequestMethod("GET");
        InputStream inputStream = connection.getInputStream();
        return inputStream;
    }

    //获取流数据
    public String getString(String urls) {
        InputStream in = null;
        ByteArrayOutputStream stream = null;
        String result = null;
        try {
            in = getInputStream(urls);
            stream = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = in.read(b)) != -1) {
                stream.write(b, 0, len);
            }
            result = stream.toString(CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean shouldBeProcessed(HttpURLConnection conn) throws IOException {
        return conn.getResponseCode() == 200;
    }


}
