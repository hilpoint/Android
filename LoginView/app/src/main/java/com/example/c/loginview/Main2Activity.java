package com.example.c.loginview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent  = getIntent();
        String value = intent.getStringExtra("id");

        if (!"".equals(value) && !value.isEmpty()) {
            EditText myReqId = (EditText) findViewById(R.id.myReqId);
            myReqId.setText(value);
        }


    }
}
