package com.example.service3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;


public class MyService extends Service {

    private Timer timer;
    private TimerTask timerTask;
    MediaPlayer mp;

    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);



    public MyService() {

    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (intent.getAction().equals("start")) {
            play();
            startTimer();
        } else {
            stop();
            stopSelf();
        }

        return START_STICKY;
    }

    public void startTimer() {
        timer = new Timer();

        timerTask = new TimerTask() {
            public void run() {
                stop();

            }
        };
        timer.schedule(timerTask,10000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stoptimertask();
    }

    public void stoptimertask() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void play() {
        mp = MediaPlayer.create(getApplicationContext(), notification);
        mp.setLooping(true);
        mp.start();

    }

    public void stop() {
        if (mp != null) mp.stop();
    }



}
