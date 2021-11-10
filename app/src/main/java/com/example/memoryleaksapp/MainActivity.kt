package com.example.memoryleaksapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var openSecondActivityBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        openSecondActivity()
    }

    private fun initViews() {
        openSecondActivityBtn = findViewById(R.id.openSecondActivityBtn)
    }

    private fun openSecondActivity() {
        openSecondActivityBtn.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}