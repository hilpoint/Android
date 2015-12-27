package com.mycompany.t24_appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by c on 2015-12-27.
 */
public class MyAppWidget extends AppWidgetProvider {
    final String ACTION_MYAPPWIDGET_DISPLAY = "MyAppWidget.Display";

    @Override
    public void onReceive(Context context, Intent intent) {
         super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for(int i = 0; i < appWidgetIds.length; i++) {
            GregorianCalendar cal = new GregorianCalendar();

            SimpleDateFormat weekFormat = new SimpleDateFormat("EEE");
            String strWeek = weekFormat.format(cal.getTime());

            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd");
            String strDate = dateFormat.format(cal.getTime());

            RemoteViews remote = new RemoteViews(context.getPackageName(), R.layout.myapp_widget);
            remote.setTextViewText(R.id.tvDate, strDate);
            remote.setTextViewText(R.id.tvWeekDay, strWeek);

            Intent intent = new Intent(context, MyAppWidget.class);
            intent.setAction(ACTION_MYAPPWIDGET_DISPLAY);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);

            PendingIntent pIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            remote.setOnClickPendingIntent(R.id.btnWidget, pIntent);

            appWidgetManager.updateAppWidget(appWidgetIds[i], remote);
        }
    }
}
