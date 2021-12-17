package com.example.lab3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DataActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val dataTextView: TextView = findViewById(R.id.dataTextView)
        val textData: String? = intent.getStringExtra("textData")

        dataTextView.text = textData
    }
}