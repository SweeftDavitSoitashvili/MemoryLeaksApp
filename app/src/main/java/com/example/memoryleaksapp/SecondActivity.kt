package com.example.memoryleaksapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    // Causes memory leak
    companion object {
        private lateinit var secondActivityTextView : TextView
    }

    // Fix the memory leak
    // private lateinit var secondActivityTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initViews()
    }

    private fun initViews() {
        secondActivityTextView = findViewById(R.id.secondActivityTextView)
    }
}