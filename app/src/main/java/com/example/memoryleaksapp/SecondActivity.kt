package com.example.memoryleaksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var secondActivityTextView : TextView

    companion object {
        private lateinit var testInterfaceAnonymous : TestInterface
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
        testInterfaceAnonymous.printMessage()
    }

    private fun init() {
        secondActivityTextView = findViewById(R.id.secondActivityTextView)
        initAnonymousInterface()
    }


    private fun initAnonymousInterface() {
        // memory leak case
        testInterfaceAnonymous = object : TestInterface {
            override fun printMessage() {
                d("LogPrintedMessage", secondActivityTextView.text.toString())
            }
        }
    }
}