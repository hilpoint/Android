package com.mycompany.t15_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by c on 2015-12-19.
 */
public class TestSqliteHandler {
    TestSqliteOpenHelper helper;
    SQLiteDatabase db;

    public TestSqliteHandler(Context context) {
        helper = new TestSqliteOpenHelper(context, "people.sqlite", null, 1);
    }

    public  void insert(String name, int age, String address) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("age",age);
        values.put("address",address);

        db.insert("student", null, values);
    }

    public  void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name = ?", new String[]{name});
    }

    public  void update(String name, int newAge) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", newAge);

        db.update("student", values, "name = ?", new String[]{name});
    }

    public void selectAll() {
        db = helper.getWritableDatabase();
        Cursor c = db.query("student",null,null,null,null,null,null);
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            int age = c.getInt(c.getColumnIndex("age"));
            String address = c.getString(c.getColumnIndex("address"));

            Log.d("SQLite", "id : " + id + " name : " +
                    name + " age : " + age + " address : " + address);
        }
    }
}
