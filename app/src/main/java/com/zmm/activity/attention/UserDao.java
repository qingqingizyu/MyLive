package com.zmm.activity.attention;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zmm.utlis.DBHelper;

/**
 * Created by Administrator on 2016/10/15.
 */
public class UserDao {
    private final SQLiteDatabase db;

    public UserDao(Context context) {
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    //修改数据库
    public long insert(String table, ContentValues values) {
        return db.insert(table, null, values);
    }
    //查询数据库
    public Cursor select(String sql, String[] selectionArgs) {
        return db.rawQuery(sql, selectionArgs);
    }
    //删除数据库
    public int delete(String table, String whereClause, String[] whereArgs) {
        return db.delete(table, whereClause, whereArgs);
    }
}
