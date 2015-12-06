package com.example.c.t05_listview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by c on 2015-12-06.
 */
public class MyAdapter extends BaseAdapter {

    ArrayList<MyData> list;
    Context context;
    MyAdapter(ArrayList<MyData> list, Context context) {
        this.list = list;
        this.context = context;
    }

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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
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
