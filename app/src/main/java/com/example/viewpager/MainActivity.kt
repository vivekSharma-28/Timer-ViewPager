package com.example.viewpager

import android.app.AlarmManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.viewpager.widget.ViewPager
import com.example.viewpager.Adpator.ViewAdaptor
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tab:TabLayout
    private lateinit var view:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab=findViewById(R.id.tablayout)
        view=findViewById(R.id.viewpager)
        view.offscreenPageLimit=7
        val viewAdaptor= ViewAdaptor(supportFragmentManager)
        view.adapter=viewAdaptor
        tab.setupWithViewPager(view)

    }
}