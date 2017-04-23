package com.bawei.text.ComicCenter_Fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.bawei.text.Me.Register;
import com.bawei.text.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

/**
 * 登录页面
 */
public class ComicCenter_Me extends Fragment implements View.OnClickListener {

    private SharedPreferences preferences;

    private ImageView touxiang;
    private LinearLayout dingdan;
    private LinearLayout guanzhu;
    private LinearLayout huancun;
    private LinearLayout shangdian;
    private LinearLayout shezhi;
    private LinearLayout shoucang;
    private LinearLayout xiaoxi;
    private TextView denglu;
    private SharedPreferences.Editor editor;
    private SharedPreferences denglu1;
    //处理本地相册图片的状态码
    private final static int LOCAL_IMAGE_CODE = 200;
    //处理拍照图片的状态码
    private final static int TAKE_IMAGE_CODE = 300;
    private File file;
    private LinearLayout tuichu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_denglu, null);
        touxiang = (ImageView) view.findViewById(R.id.denglu_touxiang);
        dingdan = (LinearLayout) view.findViewById(R.id.denglu_wode_dingdan);
        guanzhu = (LinearLayout) view.findViewById(R.id.denglu_wode_guanzhu);
        huancun = (LinearLayout) view.findViewById(R.id.denglu_wode_huancun);
        shangdian = (LinearLayout) view.findViewById(R.id.denglu_wode_shangdian);
        shezhi = (LinearLayout) view.findViewById(R.id.denglu_wode_shezhi);
        shoucang = (LinearLayout) view.findViewById(R.id.denglu_wode_shoucang);
        xiaoxi = (LinearLayout) view.findViewById(R.id.denglu_wode_xiaoxi);
        denglu = (TextView) view.findViewById(R.id._denglu_te_denglu);
        tuichu = (LinearLayout) view.findViewById(R.id.denglu_wode_tuichu);

        touxiang.setOnClickListener(this);
        shangdian.setOnClickListener(this);
        dingdan.setOnClickListener(this);
        guanzhu.setOnClickListener(this);
        huancun.setOnClickListener(this);
        shezhi.setOnClickListener(this);
        shoucang.setOnClickListener(this);
        xiaoxi.setOnClickListener(this);
        tuichu.setOnClickListener(this);

        SharedPreferences denglu2 = getActivity().getSharedPreferences("denglu", MODE_PRIVATE);
        String string = denglu2.getString("name", "登录");
        denglu.setText(string);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.denglu_touxiang:
                SharedPreferences sp = getActivity().getSharedPreferences("denglu", MODE_PRIVATE);
                if (!sp.getBoolean("oo", false)) {
                    Intent intent1 = new Intent(getActivity(), Register.class);
                    startActivityForResult(intent1, 500);
                } else {
                    dialog();
                }

                break;
            case R.id.denglu_wode_dingdan:
                baocun();

                break;
            case R.id.denglu_wode_guanzhu:
                baocun();
                break;
            case R.id.denglu_wode_huancun:
                break;
            case R.id.denglu_wode_shangdian:
                break;
            case R.id.denglu_wode_shezhi:
                break;
            case R.id.denglu_wode_shoucang:
                baocun();
                break;
            case R.id.denglu_wode_xiaoxi:
                baocun();
                break;
            case R.id.denglu_wode_tuichu:
                SharedPreferences.Editor editor = denglu1.edit();
                editor.putBoolean("oo", false);
                editor.commit();
                touxiang.setImageResource(R.mipmap.ic_personal_headportrait);
                denglu.setText("登录");

                break;

        }
    }

    private void dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setItems(new String[]{"拍照", "相册"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        //调用相机
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, TAKE_IMAGE_CODE);
                        break;
                    case 1:
                        //打开图片库
                        Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                        intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                        startActivityForResult(intent1, LOCAL_IMAGE_CODE);
                        break;
                }
            }
        });
        builder.create().show();
    }

    private void baocun() {
        denglu1 = getActivity().getSharedPreferences("denglu", MODE_PRIVATE);
        if (!denglu1.getBoolean("oo", false)) {
            Intent intent = new Intent(getActivity(), Register.class);
            startActivity(intent);
        } else {
            Toast.makeText(getActivity(), "已登录", Toast.LENGTH_SHORT).show();
        }
    }

    public void setText(String text) {
        if (!TextUtils.isEmpty(text)) {
            denglu.setText(text);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        denglu1 = getActivity().getSharedPreferences("ii", 0);

        String ii = denglu1.getString("111", null);
        if (ii != null) {
            setText(ii);
        }
        super.onActivityCreated(savedInstanceState);
        //zhang hu ming
        //String string = preferences.getString("123", null);

    }


    //回调方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断结果码
        if (resultCode == getActivity().RESULT_OK) {
            //判断请求码 返回相册数据

            if (requestCode == LOCAL_IMAGE_CODE) {
                getLocalImage(data);
            } else if (requestCode == TAKE_IMAGE_CODE) {//判断请求码 返回拍照数据
                takeImage(data);
            }
        } else if (resultCode == 111) {
            String zhanghao = data.getStringExtra("zhanghao");
            setText(zhanghao);

            SharedPreferences denglu = getActivity().getSharedPreferences("denglu", MODE_PRIVATE);
            SharedPreferences.Editor editor = denglu.edit();
            editor.putString("name", zhanghao);
            editor.commit();
        }
    }

    //返回拍照数据
    private void takeImage(Intent data) {
        Bundle bundle = data.getExtras();
        Bitmap bitmap = (Bitmap) bundle.get("data");

        touxiang.setImageBitmap(bitmap);

    }

    //图片显示前保存sdcard
    private File saveBitmap(Bitmap bitmap) {
        File file = new File(Environment.getExternalStorageDirectory(), "a.jpg");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    //获取到本地图片数据
    private void getLocalImage(Intent data) {

        Uri uri = data.getData();
        //把uri转换成bitmap
        Bitmap bitmap = getBitmapFromUri(uri);
        //图片显示前保存sdcard
        file = saveBitmap(bitmap);
        //显示图片
        touxiang.setImageBitmap(bitmap);

    }

    //把uri转换成bitmap
    private Bitmap getBitmapFromUri(Uri uri) {
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}

