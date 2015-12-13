package com.mycompany.t07_thread_1213;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static  final int TEXTVIEW_VALUE = 1;
    TextView textView;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
         if (msg.what == TEXTVIEW_VALUE) {
             textView.setText("count :" + msg.arg1);
         }
        }
    };
    class MyThread extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 100; i++) {
                try {
                    sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message msg = handler.obtainMessage();
                msg.what = TEXTVIEW_VALUE;
                msg.arg1 = i;
                handler.sendMessage(msg);
                //textView.setText("count :" + i);
                //Log.d("Mythread", "count : " + i);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        MyThread th = new MyThread();
        th.start();

        Log.d("Mythread", "onCreate End");
    }
}
