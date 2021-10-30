package com.example.taskreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    public static final String TITLE = "TITLE2";


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Broadcast", "Received");
        String toastText = String.format("Alarm Reboot");
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        startAlarmService(context, intent);
    }

    private void startAlarmService(Context context, Intent intent) {
        Intent intentService = new Intent(context, AlarmService.class);
        intentService.putExtra(TITLE, intent.getStringExtra(TITLE));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intentService);
        }
        else {
            context.startService(intentService);
        }
    }
}

