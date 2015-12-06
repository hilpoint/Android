package com.example.c.t06_shared_preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences("MySettings", MODE_PRIVATE);
        String value = settings.getString("name", "me");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(value);

    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences("MySettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        EditText editText = (EditText) findViewById(R.id.editText);
        String value = editText.getText().toString();

        editor.putString("name", value);
        editor.commit();
    }
}
