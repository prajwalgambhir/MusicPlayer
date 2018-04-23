package com.beebrainy.servicesexample.client.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.beebrainy.servicesexample.R;
import com.beebrainy.servicesexample.client.services.misc.music.MusicService;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPlay, btnPause, btnStop;
    Intent musicServiceIntent;
    MusicService musicService;
    boolean musicBound = false;
    private ServiceConnection musicConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.MusicBinder binder = (MusicService.MusicBinder) service;
            //get service
            musicService = binder.getService();
            //pass list

            musicBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        musicServiceIntent = new Intent(this, MusicService.class);
        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(this);
        btnPause = findViewById(R.id.btnPause);
        btnPause.setOnClickListener(this);
        btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay: {
                if (!musicBound) {
                    bindService(musicServiceIntent, musicConnection, BIND_AUTO_CREATE);
                } else {

                }
                break;
            }
            case R.id.btnPause: {
//                startService(musicServiceIntent);
                break;
            }
            case R.id.btnStop: {
                stopService(musicServiceIntent);
                break;
            }
        }
    }
}
