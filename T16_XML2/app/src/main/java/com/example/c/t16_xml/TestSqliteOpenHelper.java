package com.example.c.t16_xml;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by c on 2015-12-19.
 */
public class TestSqliteOpenHelper extends SQLiteOpenHelper {
    public TestSqliteOpenHelper(Context context, String name,
                                SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String  sql = "create table forecast (id integer primary key autoincrement, "+
               "day text, hour text, temp text, wfKor text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists forecast";
        db.execSQL(sql);

        onCreate(db);
    }
}
