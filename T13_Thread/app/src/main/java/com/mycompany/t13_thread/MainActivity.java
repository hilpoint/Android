package com.mycompany.t13_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final int TEXTVIEW_VALUE = 1;
    TextView textView;

    Handler handler = new Handler() {
      public void handleMessage(Message msg) {
          if (msg.what == TEXTVIEW_VALUE) {
              textView.setText("value : " + msg.arg1);
          }
      }
    };

    class  MyThread extends Thread {
        public void run(){
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
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("setText test");

        MyThread th = new MyThread();
        th.start();
    }
}
