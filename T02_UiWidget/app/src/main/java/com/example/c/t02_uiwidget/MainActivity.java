package com.example.c.t02_uiwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
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
                Toast.makeText(getApplicationContext(), "checked",
                        Toast.LENGTH_LONG).show();
            }
        });

        RadioGroup myRGroup = (RadioGroup) findViewById(R.id.myRGroup);
        myRGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.myR1:
                        Toast.makeText(getApplicationContext(),"myR1",
                                Toast.LENGTH_LONG).show();
                        break;
                    case R.id.myR2:
                        Toast.makeText(getApplicationContext(),"myR2",
                                Toast.LENGTH_LONG).show();
                        break;
                    case R.id.myR3:
                        Toast.makeText(getApplicationContext(),"myR3",
                                Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        final EditText myEdit = (EditText) findViewById(R.id.myEdit);

        Button myButton = (Button) findViewById(R.id.myButton);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), myEdit.getText(),
                        Toast.LENGTH_LONG).show();

                myEdit.setText("");
            }
        });
    }

}
