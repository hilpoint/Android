package com.mycompany.t09_br;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by c on 2015-12-12.
 */
public class MyBR extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");

            String str = "";
            for(int i = 0; i < pdus.length; i++) {
                SmsMessage msg = SmsMessage.createFromPdu((byte[])pdus[i]);
                str += "SMS FROM : " + msg.getOriginatingAddress();
                str += " MSG : " + msg.getMessageBody() + "\n";
            }

            Log.d("MyBR", str);
        }
    }
}
