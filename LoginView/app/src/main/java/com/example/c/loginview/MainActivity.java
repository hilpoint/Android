package com.example.c.loginview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myLogin = (Button) findViewById(R.id.myLogin);
        myLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText myId = (EditText) findViewById(R.id.myId);

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("id", myId.getText().toString());
                startActivity(intent);
            }
        });

    }
}
