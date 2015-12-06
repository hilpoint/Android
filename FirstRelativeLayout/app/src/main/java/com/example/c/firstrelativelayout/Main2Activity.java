package com.example.c.firstrelativelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent  = getIntent();
        String value = intent.getStringExtra("id");

        if (!"".equals(value) && !value.isEmpty()) {
            EditText returnId = (EditText) findViewById(R.id.returnId);
            returnId.setText(value);
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.desert);
    }
}
