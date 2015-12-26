package com.mycompany.t21_fragment2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by c on 2015-12-26.
 */
public class MyCounterFragment extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        textView = (TextView) view.findViewById(R.id.tvCounter);
        Button btnIncrease = (Button) view.findViewById(R.id.btnIncrease);
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(textView.getText().toString());
                value++;
                textView.setText(""+value);
            }
        });
        return view;
    }
}

