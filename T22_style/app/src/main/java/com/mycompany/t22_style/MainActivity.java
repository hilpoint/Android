package com.mycompany.t22_style;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView selectedTextView, workingTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedTextView = (TextView) findViewById(R.id.selectedTextView);
        workingTextView = (TextView) findViewById(R.id.workingTextView);


        View.OnClickListener numberButtonListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                String str = btn.getText().toString();
                String working = workingTextView.getText().toString();
                if(working.equals("0")) {
                    workingTextView.setText(str);
                }else{
                    workingTextView.append(str);
                }
            }
        };

        int number = 1;
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableLayout);
        for(int i=2; i<tableLayout.getChildCount()-1; i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for(int k=0; k < row.getChildCount(); k++) {
                Button button = (Button) row.getChildAt(k);
                button.setText(""+number);
                number++;
            }
        }
        TableRow row = (TableRow) tableLayout.getChildAt( tableLayout.getChildCount()-1);
        Button btnDelete = (Button) row.getChildAt(0);
        btnDelete.setText("DELETE");
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workingTextView.setText("0");
            }
        });

        Button btnZero = (Button) row.getChildAt(1);
        btnZero.setText("0");
        btnZero.setOnClickListener(numberButtonListener);

        Button btnApply = (Button) row.getChildAt(2);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = workingTextView.getText().toString();
                if(str.length() > 0) {
                    selectedTextView.setText(str);
                }
                workingTextView.setText("0");
            }
        });
    }
}
