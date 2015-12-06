package com.example.c.t04_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        String value = intent.getStringExtra("myData");

        Toast.makeText(getApplicationContext(), value,
                Toast.LENGTH_LONG).show();
    }
}
