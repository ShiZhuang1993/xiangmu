package com.bawei.text.utils;

import android.os.AsyncTask;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/22 15:15
 */

public class AsyncTaskUilrs extends AsyncTask<String, Integer, String> {
    @Override
    protected String doInBackground(String... params) {
        return HttpIOUtils.getInstance().getString(params[0]);
    }
}
