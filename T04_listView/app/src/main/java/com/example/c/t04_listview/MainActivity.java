package com.example.c.t04_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] list = {"hello", "world", "oracle", "java",
            "hello", "world", "oracle", "java",
            "hello", "world", "oracle", "java",
            "hello", "world", "oracle", "java"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, list);

        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), list[position],
//                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra("myData", list[position]);
                startActivity(intent);
            }
        });
    }
}
