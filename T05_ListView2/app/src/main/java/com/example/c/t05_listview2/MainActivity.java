package com.example.c.t05_listview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class MyData {
        String title;
        String desc;
        int imgIcon;

        public MyData(String title, String desc, int imgIcon) {
            this.title = title;
            this.desc = desc;
            this.imgIcon = imgIcon;
        }
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_view, null);
            }
            TextView textTitle = (TextView) convertView.findViewById(R.id.item_title);
            TextView textDesc = (TextView) convertView.findViewById(R.id.item_desc);
            ImageView icon = (ImageView) convertView.findViewById(R.id.item_icon);

            MyData myData = list.get(position);

            textTitle.setText(myData.title);
            textDesc.setText(myData.desc);
            icon.setImageResource(myData.imgIcon);

            return convertView;
        }
    }

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

        MyAdapter myAdapter = new MyAdapter();
        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);


    }
}
