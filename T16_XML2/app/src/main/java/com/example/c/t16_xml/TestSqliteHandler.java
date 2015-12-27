package com.example.c.t16_xml;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by c on 2015-12-19.
 */
public class TestSqliteHandler {
    TestSqliteOpenHelper helper;
    SQLiteDatabase db;

    public TestSqliteHandler(Context context){
        helper = new TestSqliteOpenHelper(context, "forecast.sqlite", null, 1);
    }

    public void insert(String day, String hour, String temp, String wfKor){

        GregorianCalendar now = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        format.setCalendar(now);

        int dayInt = Integer.parseInt(day);
        now.add(Calendar.DATE, dayInt);
        day = format.format(now.getTime());
        db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("day", day);
        values.put("hour", hour);
        values.put("temp", temp);
        values.put("wfKor", wfKor);

        Cursor c= db.query("forecast",null,"day=? and hour=?", new String[]{day, hour},null,null,null);
        if(c.getCount()>0){
            db.update("forecast", values, "day = ? and hour=?", new String[]{day, hour});
            Log.d("SQLite", "update "+day+ " "+hour);
        }else{
            db.insert("forecast", null, values);
            Log.d("SQLite", "insert " + day + " " + hour);
        }
    }



    public void selectAll(){
        db = helper.getReadableDatabase();
        Cursor c = db.query("forecast",null,null, null,null,null,null);
        while(c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String day = c.getString(c.getColumnIndex("day"));
            String hour = c.getString(c.getColumnIndex("hour"));
            String temp = c.getString(c.getColumnIndex("temp"));
            String wfKor = c.getString(c.getColumnIndex("wfKor"));

        }
    }

}