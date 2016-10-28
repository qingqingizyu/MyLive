package com.zmm.utlis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 类描述:
 * 备注:SQLiteOpenHelper:
 * A helper class to manage database creation and version management.
 * 用来管理数据库的创建和版本的升级.
 */
public class DBHelper extends SQLiteOpenHelper {

    //数据库的名称
    private static final String DB_NAME = "users.db";
    //数据库的版本号.版本号>=1
    private static final int DB_VERSION = 2;

    //用来创建数据库.
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //创建表的方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        //在SQLite中主键必须是整数值.但是对于其他的字段,类型没有要求.
        String sql = "CREATE TABLE user (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,id CHAR(10),nick CHAR(20),description CHAR(50)," +
                "portrait CHAR(100),gender CHAR(10),resID CHAR(10))";
        //执行一条sql语句
        db.execSQL(sql);
    }

    //升级数据库的方法.只有当版本号发生改变才会执行
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            Log.i("TAG", "数据库升级了...");
            String sql = "ALTER TABLE person ADD COLUMN age INTEGER";
            db.execSQL(sql);
        }
    }

    //可选的方法.当数据库已经存在的情况下,会打开该数据库.
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
