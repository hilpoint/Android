package com.mycompany.t14_progressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    static final int PROGRESS_VALUE = 1;
    ProgressBar progressBar;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            progressBar.setProgress(msg.arg1);
        }
    };

    class MyThread extends Thread {
        public void run() {
            for(int i = 0; i < 101; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = handler.obtainMessage();
                msg.what = PROGRESS_VALUE;
                msg.arg1 = i;
                handler.sendMessage(msg);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        MyThread th = new MyThread();
        th.start();
    }
}
