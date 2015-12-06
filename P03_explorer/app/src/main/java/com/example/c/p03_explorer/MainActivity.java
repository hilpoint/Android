package com.example.c.p03_explorer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    ArrayList<MyData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = Environment.getExternalStorageDirectory().toString();
        File f = new File(path);
        int icon = 0;

        if (f.isDirectory()) {
            File[] files = f.listFiles();

            for(int i = 0; i < files.length; i++) {
                File child = files[i];
                String name = child.getName();

                if (child.isDirectory()) {
                    icon = R.drawable.ic_folder_black_48dp;
                } else {
                    if (isPicture(name)) {
                        icon = R.drawable.ic_photo_black_48dp;
                    } else {
                        icon = R.drawable.ic_insert_drive_file_black_48dp;
                    }
                }
                Log.d(i + " file_name", name);

                Log.d(i + " file_size", String.valueOf(child.length()));

                list.add(new MyData(name, String.valueOf(child.length()), icon));
            }

        }

        MyAdapter myAdapter = new MyAdapter(list, MainActivity.this);
        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);

    }

    public boolean isPicture(String fileName) {
        Pattern pattern = Pattern.compile("\\.(jpg|jpeg|png|gif)$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(fileName);
        return matcher.find();
    }
}
