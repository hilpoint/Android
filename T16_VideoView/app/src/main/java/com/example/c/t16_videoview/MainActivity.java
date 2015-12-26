package com.example.c.t16_videoview;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView videoView = (VideoView)findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

//        String path = Environment.getExternalStorageDirectory()+"/abc.mp4";
//        videoView.setVideoPath(path);
        videoView.setVideoURI(Uri.parse("http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_1mb.mp4"));
        videoView.start();

//        Button btnPlay = (Button)findViewById(R.id.btnPLAY);
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                videoView.start();
//            }
//        });
//
//        Button btnStop = (Button)findViewById(R.id.btnSTOP);
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                videoView.pause();
//            }
//        });
    }
}
