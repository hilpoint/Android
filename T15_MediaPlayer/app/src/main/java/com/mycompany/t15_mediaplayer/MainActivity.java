package com.mycompany.t15_mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = Environment.getExternalStorageDirectory().toString();
                path += "/Music/어깨가 들썩들썩 신나는 노래 모음/2NE1 - Fire.mp3";

                mp = new MediaPlayer();
                try {
                    mp.setDataSource(path);
                    mp.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mp.start();
            }
        });

        Button btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null) {
                    mp.stop();
                    mp.release();
                }
                mp = null;
            }
        });

        Button btnStart2 = (Button) findViewById(R.id.btnStart2);
        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.kalimba);
                mp.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mp != null) {
            mp.stop();
            mp.release();
        }
        mp = null;
    }
}
