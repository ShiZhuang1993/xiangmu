package com.bawei.text.Me;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bawei.text.R;
import com.bawei.text.utils.MySQLite;

import java.util.ArrayList;

public class Register extends AppCompatActivity {

    private ImageView fanhui;
    private ImageView touxiang;
    private ImageView tu_zhanghao;
    private EditText zhanghao;
    private ImageView tu_mima;
    private EditText mima;
    private Button denglu;
    private TextView zhuce;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        fanhui = (ImageView) findViewById(R.id._denglu_fanhui);
        TextView wangjimima = (TextView) findViewById(R.id._denglu_wangjimima);
        touxiang = (ImageView) findViewById(R.id._denglu_touxiang);
        tu_zhanghao = (ImageView) findViewById(R.id._denglu_tu_zhanghao);
        zhanghao = (EditText) findViewById(R.id._denglu_zhanghao);
        tu_mima = (ImageView) findViewById(R.id._denglu_tu_mima);
        mima = (EditText) findViewById(R.id._denglu_mima);
        denglu = (Button) findViewById(R.id._denglu_denglu);
        zhuce = (TextView) findViewById(R.id._denglu_zhuce);
        tu_zhanghao.setSelected(true);
        MySQLite mySQLite = new MySQLite(Register.this);
        database = mySQLite.getWritableDatabase();

        fanhui.setOnClickListener(new View.OnClickListener() {

            private Intent intentHui;

            @Override
            public void onClick(View v) {
                intentHui = new Intent();
                intentHui.putExtra("id", 3);
                setResult(300, intentHui);
                finish();
            }
        });
        //注意edittext要用触摸监听
        zhanghao.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                touxiang.setSelected(false);
                tu_zhanghao.setSelected(true);
                tu_mima.setSelected(false);
                return false;
            }
        });
        mima.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                touxiang.setSelected(true);
                tu_zhanghao.setSelected(false);
                tu_mima.setSelected(true);
                return false;
            }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Register.this, Register_log.class);
              startActivity(intent);
            }
        });
        denglu.setOnClickListener(new View.OnClickListener() {

            private ArrayList<NamePwdBean> list;

            @Override
            public void onClick(View v) {

                list = new ArrayList<>();
                if (!TextUtils.isEmpty(zhanghao.getText().toString())) {
                    if (!TextUtils.isEmpty(mima.getText().toString())) {
                        Cursor cursor = database.query("login", null, "name=? and pwd=?",
                                new String[]{zhanghao.getText().toString(), mima.getText().toString()}, null, null, null);
                        if (cursor.moveToNext()) {
                            Toast.makeText(Register.this, "登录成功", Toast.LENGTH_SHORT).show();
                            SharedPreferences sp = getSharedPreferences("denglu", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putBoolean("oo", true);
                            editor.commit();
                            Intent intent = new Intent();
                            intent.putExtra("zhanghao", zhanghao.getText().toString());
                            setResult(111, intent);

                            finish();
                        } else {
                            Toast.makeText(Register.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(Register.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Register.this, "请输入帐号", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
