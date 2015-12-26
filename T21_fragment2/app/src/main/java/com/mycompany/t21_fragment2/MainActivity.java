package com.mycompany.t21_fragment2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMyClick(View v) {
        FragmentManager fm = getFragmentManager();
        Fragment fr = fm.findFragmentById(R.id.frame);

        switch (v.getId()) {
            case R.id.btnAdd:
                if(fr == null) {
                    FragmentTransaction tr = fm.beginTransaction();
                    MyCounterFragment cf = new MyCounterFragment();
                    tr.add(R.id.frame, cf, "counter");
                    tr.commit();
                }
                break;
            case R.id.btnRemove:
                if(fr != null) {
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.remove(fr);
                    tr.commit();
                }
                break;
            case R.id.btnReplace:
                if(fr != null) {
                    FragmentTransaction tr = fm.beginTransaction();
                    if(fr.getTag().equals("counter")) {
                        MyTextFragment tf = new MyTextFragment();
                        tr.replace(R.id.frame, tf, "text");
                    } else {
                        MyCounterFragment cf = new MyCounterFragment();
                        tr.replace(R.id.frame, cf, "counter");
                    }
                    tr.commit();
                }
                break;
            case R.id.btnHide:
                if(fr != null) {
                    FragmentTransaction tr = fm.beginTransaction();
                    if(fr.isHidden()) {
                        tr.show(fr);
                    } else {
                        tr.hide(fr);
                    }

                    tr.commit();
                }
                break;
        }
    }
}
