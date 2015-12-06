package com.example.c.p03_explorer;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path = Environment.getExternalStorageDirectory().toString();
        File f = new File(path);

        if (f.isDirectory()) {
            File[] files = f.listFiles();

            for(int i = 0; i < files.length; i++) {
                File child = files[i];

                Log.d("EX", child.getName());
            }
        }
    }
}
