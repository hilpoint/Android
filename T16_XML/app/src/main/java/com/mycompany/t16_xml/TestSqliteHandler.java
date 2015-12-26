package com.mycompany.t16_xml;

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
        helper = new TestSqliteOpenHelper(context, "weather.sqlite", null, 1);
    }

    public  void insert(String day, String hour, String temp, String wfKor) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("day",day);
        values.put("hour",hour);
        values.put("temp",temp);
        values.put("wfKor",wfKor);

        db.insert("weather", null, values);
    }

    public  void update(String day, String hour, String newTemp, String newWfKor) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("temp",newTemp);
        values.put("wfKor",newWfKor);

        db.update("weather", values, "day = ? and hour = ?",
                new String[]{day, hour});
    }

    public void selectAll() {
        db = helper.getWritableDatabase();
        Cursor c = db.query("weather",null,null,null,null,null,null);

        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String day = c.getString(c.getColumnIndex("day"));
            String hour = c.getString(c.getColumnIndex("hour"));
            String temp = c.getString(c.getColumnIndex("temp"));
            String wfKor = c.getString(c.getColumnIndex("wfKor"));


            Log.d("SQLite", "id : " + id + " day : " +
                    day + " hour : " + hour + " temp : " + temp + " wfKor : " + wfKor);
        }
    }
}
