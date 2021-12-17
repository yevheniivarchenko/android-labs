package com.example.lab3

import android.graphics.Typeface

interface EnteredTextListener {
    fun enteredText(text: String, typeface: Typeface?)
}