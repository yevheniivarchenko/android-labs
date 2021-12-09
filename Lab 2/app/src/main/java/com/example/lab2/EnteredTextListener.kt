package com.example.lab2

import android.graphics.Typeface

interface EnteredTextListener {
    fun enteredText(text: String, typeface: Typeface?)
}