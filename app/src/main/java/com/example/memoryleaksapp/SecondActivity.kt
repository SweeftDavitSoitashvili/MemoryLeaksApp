package com.example.memoryleaksapp

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var secondActivityTextView : TextView
    private lateinit var testBroadcastReceiver: TestBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
        registerTestBroadcastReceiver()
    }

    private fun init() {
        secondActivityTextView = findViewById(R.id.secondActivityTextView)
        testBroadcastReceiver = TestBroadcastReceiver()
    }

    private fun registerTestBroadcastReceiver() {
        registerReceiver(testBroadcastReceiver, IntentFilter())
    }

    override fun onStop() {
        super.onStop()
        // unregister listeners to fix memory leak
        // unregisterReceiver(testBroadcastReceiver)
    }

}