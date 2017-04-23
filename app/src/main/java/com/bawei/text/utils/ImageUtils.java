package com.bawei.text.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bawei.text.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 类用途：
 * 作者：史壮壮
 * 时间：2017/3/16 20:27
 */

public class ImageUtils {

    public static void getImage(String url, ImageView view, Context context) {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context).discCacheFileNameGenerator(new Md5FileNameGenerator()).build();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).showImageOnLoading(R.mipmap.ic_launcher).build();
        ImageLoader.getInstance().init(configuration);
        ImageLoader.getInstance().displayImage(url, view, options);

    }
}
