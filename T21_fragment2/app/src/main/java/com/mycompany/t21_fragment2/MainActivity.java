package com.mycompany.t21_fragment2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

//    이 아래 소스는 백스택 안되.....
//    public static class CountingFragment extends Fragment {
//        int mNum;
//
//        static CountingFragment newInstance(int num) {
//            CountingFragment f = new CountingFragment();
//
//            Bundle args = new Bundle();
//            args.putInt("num", num);
//            f.setArguments(args);
//            return f;
//        }
//        @Override
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            mNum = getArguments() != null ? getArguments().getInt("num") : 1;
//        }
//
//        @Nullable
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            View v = inflater.inflate(R.layout.fragment_counter, container, false);
//            View tv = v.findViewById(R.id.tvCounter);
//            ((TextView)tv).setText("Fragment #" + mNum);
//            return v;
//        }
//    }
//
//    int mStackLevel = 0;
//    void addFragmentToStack() {
//        mStackLevel++;
//
//        Fragment newFragment = CountingFragment.newInstance(mStackLevel);
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.replace(R.id.frame, newFragment);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        ft.addToBackStack(null);
//        ft.commit();
//    }

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
            {//if(fr == null) {
                    FragmentTransaction tr = fm.beginTransaction();
                    MyCounterFragment cf = new MyCounterFragment();
                    tr.add(R.id.frame, cf, "counter");
                    tr.addToBackStack(null);
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
                    tr.addToBackStack(null);
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
