package com.bawei.text.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.RadioGroup;

import com.bawei.text.R;
import com.bawei.text.ComicCenter_Fragment.ComicCenter_Recommend;
import com.bawei.text.ComicCenter_Fragment.ComicCenter_Discover;
import com.bawei.text.ComicCenter_Fragment.ComicCenter_VCommunity;
import com.bawei.text.ComicCenter_Fragment.ComicCenter_Me;

public class ComicCenter extends FragmentActivity {


    private RadioGroup group;
    private ComicCenter_Recommend fragment_01;
    private ComicCenter_Discover fragment_02;
    private ComicCenter_VCommunity fragment_03;
    private ComicCenter_Me fragment_04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        group = (RadioGroup) findViewById(R.id.main_radiogroup);
        fragment_01 = new ComicCenter_Recommend();
        fragment_02 = new ComicCenter_Discover();
        fragment_03 = new ComicCenter_VCommunity();
        fragment_04 = new ComicCenter_Me();

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.main_framelayout, fragment_01);
        transaction.commit();

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                             @Override
                                             public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                 FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                                                 switch (checkedId) {
                                                     case R.id.radio_button_01:
                                                         transaction1.replace(R.id.main_framelayout, fragment_01);
                                                         break;
                                                     case R.id.radio_button_02:
                                                         transaction1.replace(R.id.main_framelayout, fragment_02);
                                                         break;
                                                     case R.id.radio_button_03:
                                                         transaction1.replace(R.id.main_framelayout, fragment_03);
                                                         break;
                                                     case R.id.radio_button_04:
                                                         transaction1.replace(R.id.main_framelayout, fragment_04);
                                                         break;
                                                 }
                                                 transaction1.commit();
                                             }
                                         }
        );

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        SharedPreferences sharedPreferences = getSharedPreferences("config", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (data != null) {
            String zhanghao = data.getStringExtra("zhanghao");
            edit.putString("123", zhanghao);
            edit.commit();
        }
    }

}
