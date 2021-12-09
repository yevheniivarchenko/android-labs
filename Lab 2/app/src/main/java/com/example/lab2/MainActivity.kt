package com.example.lab2

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), EnteredTextListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun enteredText(text: String, typeface: Typeface?) {
        val resultFragment: ResultFragment = supportFragmentManager.findFragmentById(R.id.resultFragment) as ResultFragment

        resultFragment.setOutputText(text, typeface)
    }
}