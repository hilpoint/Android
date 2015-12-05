package com.example.c.t02_uiwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox myCheckBox = (CheckBox)findViewById(R.id.myCheckBox);
//        myCheckBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(myCheckBox.isChecked()) {
//                    Toast.makeText(getApplicationContext(), "checkbox checked",
//                            Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "checkbox unchecked",
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(),"checked",
                        Toast.LENGTH_LONG).show();
            }
        });

        RadioGroup myRGroup = (RadioGroup) findViewById(R.id.myRGroup);
        myRGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.myR1:
                        break;
                    case R.id.myR2:
                        break;
                    case R.id.myR3:
                        break;
                }
            }
        });
    }

}
