package com.example.viewpager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings

class MyReceiver : BroadcastReceiver() {
    private lateinit var media:MediaPlayer

    override fun onReceive(context: Context?, intent: Intent?) {
        media=MediaPlayer.create(context,Settings.System.DEFAULT_ALARM_ALERT_URI)
        media.isLooping=true
        media.start()
    }
}