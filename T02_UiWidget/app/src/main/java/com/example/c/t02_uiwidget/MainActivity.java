package com.example.c.t02_uiwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox myCheckBox = (CheckBox)findViewById(R.id.myCheckBox);
        myCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myCheckBox.isChecked()) {
                    Toast.makeText(getApplicationContext(), "checkbox checked",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "checkbox unchecked",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
