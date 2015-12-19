package com.mycompany.p_musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    ArrayList<MyData> list = new ArrayList<>();
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = Environment.getExternalStorageDirectory().toString() + "/Music/어깨가 들썩들썩 신나는 노래 모음";
        File f = new File(path);
        int icon = 0;

        if (f.isDirectory()) {
            File[] files = f.listFiles();

            for(int i = 0; i < files.length; i++) {
                File child = files[i];
                String name = child.getName();

                if (child.isDirectory()) {
                    icon = R.drawable.ic_folder_black_48dp;

                    list.add(new MyData(name, "Directory", icon));
                } else {
                    if(isMP3(name)) {
                        icon = R.drawable.ic_insert_drive_file_black_48dp;
                        list.add(new MyData(name, path, icon));
                    }
                }
            }
        }

        MyAdapter myAdapter = new MyAdapter(list, MainActivity.this);
        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    public boolean isMP3(String fileName) {
        Pattern pattern = Pattern.compile("\\.(mp3)$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(fileName);
        return matcher.find();
    }
}