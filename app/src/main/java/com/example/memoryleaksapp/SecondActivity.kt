package com.example.memoryleaksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var secondActivityTextView : TextView

    companion object {
        private lateinit var testInterface : TestInterface
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
        testInterface.printMessage(secondActivityTextView.text.toString())
    }

    private fun init() {
        secondActivityTextView = findViewById(R.id.secondActivityTextView)
        testInterface = TestInterfaceImpl()
    }

    // fix memory leak
    class TestInterfaceImpl : TestInterface {
        override fun printMessage(message: String) {
            d("LogPrintedMessage", message)
        }
    }
}