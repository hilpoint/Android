package com.example.c.t03_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent  = getIntent();
        String value = intent.getStringExtra("id");

        Toast.makeText(getApplicationContext(), value,
                Toast.LENGTH_LONG).show();

        Button btnEnd = (Button) findViewById(R.id.btnEnd);
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent();
                myIntent.putExtra("myResult","Main2 Result success");
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });
    }
}
