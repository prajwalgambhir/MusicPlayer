package com.beebrainy.servicesex.client.services.misc.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MusicService extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer
        .OnErrorListener, MediaPlayer.OnCompletionListener {

    MyMediaPlayerWrapper mediaPlayer;
    private final IBinder musicBind = new MusicBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    public class MusicBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }

    }

    @Override
    public void onCreate() {
        Log.d(MusicService.class.getSimpleName(), "Service created");
        mediaPlayer = new MyMediaPlayerWrapper(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(MusicService.class.getSimpleName(), "onStartCommand");
        mediaPlayer.start();
        int i = super.onStartCommand(intent, flags, startId);
        Log.d(MusicService.class.getSimpleName(), "Int returned:" + i);
        return i;
    }

    @Override
    public void onDestroy() {
        Log.d(MusicService.class.getSimpleName(), "onDestroy");
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        mediaPlayer.stop();
        mediaPlayer.release();
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
    }
}