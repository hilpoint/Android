package com.mycompany.t15_sqlite;

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
        String sql = "create table student (id integer primary key autoincrement, "+
                "name text, age integer, address text)";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists student";
        db.execSQL(sql);

        onCreate(db);
    }
}
