package com.sourceit.task1.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.sourceit.task1.R;
import com.sourceit.task1.utils.L;

/**
 * Created by User on 12.02.2016.
 */
public class MyReceiver extends BroadcastReceiver {

    private final int ID = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        L.d("onReceive");

        NotificationManager nm = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (intent.getAction().equals("android.intent.action.AIRPLANE_MODE")) {
            if (intent.getBooleanExtra("state", false) == false) {
                L.d("onReceive false");
                nm.cancel(ID);
            } else if (intent.getBooleanExtra("state", false) == true) {
                L.d("onReceive true");
                Intent notificationIntent = new Intent();
                PendingIntent contentIntent = PendingIntent.getActivity(context,
                        ID, notificationIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
                builder.setContentIntent(contentIntent)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setTicker("Большой брат следит за тобой")
                        .setContentText("Большой брат следит за тобой");

                Notification n = builder.build();
                nm.notify(ID, n);
            }
        }
    }
}
