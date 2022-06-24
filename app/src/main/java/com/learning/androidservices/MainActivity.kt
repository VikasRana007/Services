package com.learning.androidservices

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.learning.androidservices.MyBackgroundService.Companion.MARKS
import com.learning.androidservices.MyBackgroundService.Companion.NAME
import com.learning.androidservices.MyBackgroundService.Companion.TAG
import com.learning.androidservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        val serviceIntent = Intent(this, MyBackgroundService::class.java)
        serviceIntent.putExtra(NAME, "VIKAS")
        serviceIntent.putExtra(MARKS, 88)
        activityMainBinding.startService.setOnClickListener {
            Log.i(TAG, "Starting Service")
            startService(serviceIntent)
        }

        activityMainBinding.stopService.setOnClickListener {
            Log.i(TAG, "Stopping Service")
            stopService(serviceIntent)
        }

    }
}