package com.mycompany.t12_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    NotificationManager notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Button btnStart = (Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                // 인텐트를 담아 전달해주는 역할할
               PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
                        0, intent, 0);
                Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.chrysanthemum);
                Notification notification = new NotificationCompat.Builder(MainActivity.this)
                        .setContentTitle("ContentTitle")
                        .setContentText("ContentText")
                        .setSubText("SubText")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(bm)
                        .setContentIntent(pendingIntent)
                        .setTicker("Notification test~")
                        .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)
                        .setVibrate(new long[]{0, 1000})
                        .build();
                notificationManager.notify(1234, notification);
            }
        });

        Button btnNoti = (Button) findViewById(R.id.btnNoti);
        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.chrysanthemum);

                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setSmallIcon(R.mipmap.ic_launcher);

                Notification.BigPictureStyle bigStyle = new Notification.BigPictureStyle(builder);
                bigStyle.bigPicture(bm);
                builder.setStyle(bigStyle);

                builder.setAutoCancel(true);

                Notification noti = builder.build();
                notificationManager.notify(1234, noti);

            }
        });
    }
}
