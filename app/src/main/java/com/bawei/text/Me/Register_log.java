package com.bawei.text.Me;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.bawei.text.R;
import com.bawei.text.utils.MySQLite;

public class Register_log extends AppCompatActivity {

    private EditText zhanghao;
    private EditText mima;
    private Button zhuce;
    private Button quxiao;
    private SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register_log);
        zhanghao = (EditText) findViewById(R.id.zhuce_zhanghao);
        mima = (EditText) findViewById(R.id.zhuce_mima);
        zhuce = (Button) findViewById(R.id.zhuce_zhuce);
        quxiao = (Button) findViewById(R.id.zhuce_quxiao);
        MySQLite mySQLite = new MySQLite(Register_log.this);
        database = mySQLite.getWritableDatabase();


        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(zhanghao.getText().toString())) {
                    if (!TextUtils.isEmpty(mima.getText().toString())) {
                        ContentValues values = new ContentValues();
                        values.put("name", zhanghao.getText().toString());
                        values.put("pwd", mima.getText().toString());
                        database.insert("login", null, values);
                        Toast.makeText(Register_log.this, "注册成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(Register_log.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Register_log.this, "请输入帐号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
