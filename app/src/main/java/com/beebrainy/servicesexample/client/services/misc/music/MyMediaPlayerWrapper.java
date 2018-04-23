package com.beebrainy.servicesexample.client.services.misc.music;

import android.content.Context;
import android.media.MediaPlayer;

import com.beebrainy.servicesexample.R;

/**
 * Created by Prajwal Gambhir on 20-Apr-18.
 * Copyright (2018) by Cogitate Technology Solution
 */

public class MyMediaPlayerWrapper {

    private static MediaPlayer mPlayer;

    public MyMediaPlayerWrapper(Context context) {
        this.mPlayer = MediaPlayer.create(context, R.raw.yeah_yeah);
    }

    public void start() {
        mPlayer.start();
    }

    public void stop() {
        mPlayer.stop();
    }

    public void pause() {
        mPlayer.pause();
    }

    public boolean isPlaying() {
        return mPlayer.isPlaying();
    }

    public void release() {
        mPlayer.release();
    }
}
