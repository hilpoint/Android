package com.mycompany.t09_mediaplayer_1213;

import android.media.MediaPlayer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer = null;
    SeekBar seekBar;
    TextView textPlayTime =null;
    TextView textDuration =null;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 1) {
                seekBar.setProgress(msg.arg1);

                int totalSeconds = msg.arg1 / 1000;
                int minutes = totalSeconds / 60;
                int seconds = totalSeconds % 60;
                textPlayTime.setText(String.format("%02d", minutes) + " : " + String.format("%02d", seconds));
            }
        }

    };
    class MyThread extends Thread {
        @Override
        public void run() {
            while(true) {
                try {
                    if (mediaPlayer != null) {
                        if (mediaPlayer.isPlaying()) {
                            sleep(100);

                            //seekBar.setProgress(mediaPlayer.getCurrentPosition());
                            Message msg = handler.obtainMessage();
                            msg.what = 1;
                            msg.arg1 = mediaPlayer.getCurrentPosition();
                            handler.sendMessage(msg);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textPlayTime = (TextView) findViewById(R.id.textPlayTime);
        textDuration  = (TextView) findViewById(R.id.textDuration);
        Button btnStart = (Button) findViewById(R.id.btnStart);

        MyThread th = new MyThread();
        th.start();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = Environment.getExternalStorageDirectory() + "/Music/어깨가 들썩들썩 신나는 노래 모음/2NE1 - Fire.mp3";
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(path);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
                seekBar.setMax(mediaPlayer.getDuration());

                int totalSeconds = mediaPlayer.getDuration() / 100;
                int minutes = totalSeconds / 60;
                int seconds = totalSeconds % 60;

                textDuration.setText(minutes + ":" + seconds);
            }
        });

        Button btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
                mediaPlayer = null;
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    if (mediaPlayer != null)
                        mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
