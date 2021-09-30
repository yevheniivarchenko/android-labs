package com.example.lab1

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val enterTextTextView: TextView = findViewById(R.id.enterTextEditText)
        val outputTextTextView: TextView = findViewById(R.id.outputTextTextView)
        val okButton: Button = findViewById(R.id.okButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)

        var typeface: Typeface? = null

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton0 -> typeface = Typeface.DEFAULT
                R.id.radioButton1 -> typeface = Typeface.DEFAULT_BOLD
                R.id.radioButton2 -> typeface = Typeface.SERIF
                R.id.radioButton3 -> typeface = Typeface.MONOSPACE
            }
        }

        okButton.setOnClickListener {
            if (enterTextTextView.text.toString().isEmpty()) {
                val toast = Toast.makeText(applicationContext, "Empty string", Toast.LENGTH_SHORT)
                toast.show()
            } else {
                outputTextTextView.text = enterTextTextView.text
                outputTextTextView.typeface = typeface
            }
        }

        cancelButton.setOnClickListener {
            outputTextTextView.text = ""
        }
    }
}