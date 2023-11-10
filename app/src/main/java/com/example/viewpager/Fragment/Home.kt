package com.example.viewpager.Fragment

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.viewpager.MusicService
import com.example.viewpager.R


class Home : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<Button>(R.id.start).setOnClickListener()
        {
            requireContext().startService(Intent(context,MusicService::class.java))
        }

        view.findViewById<Button>(R.id.stop).setOnClickListener()
        {
            requireContext().stopService(Intent(context,MusicService::class.java))
        }

        return view
    }

}