package com.example.notificationtest;

import static android.app.Notification.PRIORITY_MAX;
import static android.app.Notification.VISIBILITY_SECRET;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send = (Button) findViewById(R.id.send_notice);
        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_notice:
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                NotificationChannel channel = new NotificationChannel("10", "my_channel", NotificationManager.IMPORTANCE_DEFAULT);
                channel.setShowBadge(true);
                channel.setLockscreenVisibility(VISIBILITY_SECRET);
                manager.createNotificationChannel(channel);

                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

                Notification notification = new NotificationCompat.Builder(this, "10")
                        .setContentTitle("Title")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("content text: this is a long text. Learn how to build notifications right now." +
                                        " Get the official Android IDE and develop tools to build apps for Android."))
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                        .setVibrate(new long[] {0, 1000, 1000, 1000})
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}