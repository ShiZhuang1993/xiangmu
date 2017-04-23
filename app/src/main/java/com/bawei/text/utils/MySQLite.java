package com.bawei.text.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/2/22.
 */
public class MySQLite extends SQLiteOpenHelper {
    public MySQLite(Context context) {
        super(context, "ComicCenten.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table login(_id Integer primary key autoincrement," +
                "name text,pwd text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
