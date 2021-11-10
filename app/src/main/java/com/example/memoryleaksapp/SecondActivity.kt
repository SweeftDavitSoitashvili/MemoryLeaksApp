package com.example.memoryleaksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private lateinit var secondActivityTextView : TextView

    companion object {
        private lateinit var testInnerClass: TestInnerClass
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
        testInnerClass.printMessage()
    }

    private fun init() {
        secondActivityTextView = findViewById(R.id.secondActivityTextView)
        testInnerClass = TestInnerClass()
    }

    //Cases Memory leak
    inner class TestInnerClass {
        fun printMessage() {
            d("LogPrintedMessage", secondActivityTextView.text.toString())
        }
    }
}