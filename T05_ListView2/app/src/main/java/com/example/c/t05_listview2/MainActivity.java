package com.example.c.t05_listview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MyData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int icon = 0;
        for(int i = 0; i < 30; i++) {
            switch (i%4) {
                case 0:
                    icon = R.drawable.ic_movie_black_48dp;
                    break;
                case 1:
                    icon = R.drawable.ic_new_releases_black_48dp;
                    break;
                case 2:
                    icon = R.drawable.ic_search_white_48dp;
                    break;
                case 3:
                    icon = R.drawable.ic_settings_input_component_black_48dp;
                    break;
            }
            list.add(new MyData("data"+i, "desc"+i, icon));
        }

        MyAdapter myAdapter = new MyAdapter(list, MainActivity.this);
        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);


    }
}
