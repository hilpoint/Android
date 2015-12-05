package com.example.c.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myBtn = (Button)findViewById(R.id.btn);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
            }
        });
        Button myBtn2 = (Button)findViewById(R.id.btn2);
        myBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myTag","button2 click");
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.naver.com"));
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "button2", Toast.LENGTH_LONG).show();
            }
        });
        Button myBtn3 = (Button)findViewById(R.id.btn3);
        myBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("tel:010-5011-9120"));
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "button3", Toast.LENGTH_LONG).show();
            }
        });
    }
}
