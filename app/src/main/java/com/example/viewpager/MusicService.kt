package com.example.viewpager

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MusicService : Service() {
    private lateinit var media:MediaPlayer


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        media= MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI)
        media.isLooping=true
        media.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {

        media.stop()
        super.onDestroy()
    }


}