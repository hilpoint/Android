package com.mycompany.t11_br3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by c on 2015-12-12.
 */
public class MyCustomBR extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "onReceived called", Toast.LENGTH_SHORT).show();
    }
}
