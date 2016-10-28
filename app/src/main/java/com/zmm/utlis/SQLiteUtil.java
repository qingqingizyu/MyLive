package com.zmm.utlis;

/**
 * Created by zouzouzou1 on 2016/10/15.
 */

public class SQLiteUtil {
//    private SQLiteDatabase mDb = new UserDao(this);
//    private UserDao mDao = mDao.getDb();
//
//    //添加数据
//    public void save() {
//        ContentValues values = new ContentValues();
//        //集合中的key就是表中的列名.
//        values.put("name", "李逵");
//        values.put("nickname", "黑旋风");
//        values.put("age", 38);
//        //返回值:最后那一行的行号.
//        long id = mDb.insert("person", null, values);
//        if (id > 0) {
//            Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
//        }
//    }
//    //删除
//    public void delete(View view) {
//        int id = mDb.delete("person", "_id = ?", new String[]{String.valueOf(2)});
//        if (id > 0) {
//            Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    //修改
//    public void update() {
//        ContentValues values = new ContentValues();
//        values.put("nickname", "及时雨");
//        //返回值:受这条修改语句影响的行数.
//        int id = mDb.update("person", values, "name = ? ", new String[]{"宋江"});
//        if (id > 0) {
//            Toast.makeText(MainActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    //查询数据
//    public void query() {
//        Cursor cursor = mDb.query("person", new String[]{"nickname"}, "name = ?", new String[]{"李逵"}, null, null, null);
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                //根据列名得到列号
//                int nickname = cursor.getColumnIndex("nickname");
//                //根据列号得到对应的值
//                String value = cursor.getString(nickname);
//                Log.i("TAG", "value=" + value);
//            }
//            //要记得关闭cursor
//            cursor.close();
//        }
//    }
}
