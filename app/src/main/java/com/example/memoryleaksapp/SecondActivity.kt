package com.example.memoryleaksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import android.widget.TextView
import java.lang.ref.WeakReference

class SecondActivity : AppCompatActivity() {

    private lateinit var secondActivityTextView : TextView
    private lateinit var showToastMessageBtn : Button
    private lateinit var testThread: TestThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }

    private fun init() {
        secondActivityTextView = findViewById(R.id.secondActivityTextView)
        showToastMessageBtn = findViewById(R.id.showToastMessageBtn)
        displayMessage(secondActivityTextView.text.toString())
        testThread = TestThread(WeakReference(this))
        testThread.start()
    }

    private fun makeFakeApiCall() {
        Thread.sleep(10000)
        d("LogPrintedMessage", "Response")
    }

    private fun displayMessage(message : String) {
        showToastMessageBtn.setOnClickListener {
            d("LogPrintedMessage", message)
        }
    }

    // fix memory leak case by passing weak reference
    class TestThread(var secondActivity: WeakReference<SecondActivity>) : Thread() {
        override fun run() {
            super.run()
            secondActivity.get()?.makeFakeApiCall()
        }
    }
}