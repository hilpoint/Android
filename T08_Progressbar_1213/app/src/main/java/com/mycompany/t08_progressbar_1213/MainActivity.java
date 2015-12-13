package com.mycompany.t08_progressbar_1213;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int PROGRESS_VALUE = 1;

    TextView textPercent;
    TextView textValue;
    ProgressBar progressBar;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what  == PROGRESS_VALUE) {
                progressBar.setProgress(msg.arg1);

                int max = progressBar.getMax();

                textPercent.setText((msg.arg1*100)/max+"%");

                textValue.setText(msg.arg1+ "/" + max );
            }
        }
    };

    class MyThread extends Thread {
        @Override
        public void run() {
            for(int i = 0; i < 200; i+=5) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //progressBar.setProgress(i);
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

        textPercent = (TextView) findViewById(R.id.textPercent);
        textValue = (TextView) findViewById(R.id.textValue);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        MyThread th = new MyThread();
        th.start();
    }
}
