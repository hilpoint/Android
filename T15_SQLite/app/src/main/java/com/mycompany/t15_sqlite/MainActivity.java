package com.mycompany.t15_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestSqliteHandler handler = new TestSqliteHandler(this);
        handler.insert("kim", 20, "seoul");
        handler.insert("lee", 21, "인천");
        handler.insert("park", 22, "부산");
        handler.insert("jeon", 23, "seoul");

        handler.delete("park");
        handler.update("kim", 40);

        handler.selectAll();
    }
}
