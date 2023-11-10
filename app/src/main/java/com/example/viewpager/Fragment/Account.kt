package com.example.viewpager.Fragment

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viewpager.MyReceiver
import com.example.viewpager.R

class Account : Fragment() {

    private lateinit var edittextTime:EditText
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_account, container, false)
        val alarmManager: AlarmManager = activity?.getSystemService(ALARM_SERVICE) as AlarmManager

        edittextTime=view.findViewById(R.id.time)
        button=view.findViewById(R.id.set_Alarm)

        button.setOnClickListener {

            val time:Int=edittextTime.text.toString().toInt()
            val trigger= SystemClock.elapsedRealtime() + (time * 1000)
            val broadCast = Intent(this@Account.requireContext(),MyReceiver::class.java)
            val pendingIntent=PendingIntent.getBroadcast(this.requireActivity(),100,broadCast,PendingIntent.FLAG_MUTABLE)

            alarmManager.setInexactRepeating(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                trigger,1000
               , pendingIntent
            )

            Toast.makeText(this.requireContext(),"Time Set",Toast.LENGTH_SHORT).show()


        }

        return view
    }


}