package com.example.lab1

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var enterTextTextView: TextView
    private lateinit var outputTextTextView: TextView
    private lateinit var okButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        enterTextTextView = findViewById(R.id.enterTextEditText)
        outputTextTextView = findViewById(R.id.outputTextTextView)
        okButton = findViewById(R.id.okButton)
        cancelButton = findViewById(R.id.cancelButton)

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
            if (enterTextTextView.text.toString() == "") {
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