package com.mycompany.t13_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    class  MyThread extends Thread {
        public void run(){
            for(int i = 0; i < 100; i++) {

                try {
                    sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("TEST", "value : " + i);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyThread th = new MyThread();
        th.start();
    }
}
