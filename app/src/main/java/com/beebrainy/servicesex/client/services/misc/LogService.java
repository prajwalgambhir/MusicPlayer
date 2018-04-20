package com.beebrainy.servicesex.client.services.misc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class LogService extends Service {
    public LogService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Log.d(LogService.class.getSimpleName(), "Timing");
            }
        }, 1000, 3000);
        return super.onStartCommand(intent, flags, startId);
    }
}
