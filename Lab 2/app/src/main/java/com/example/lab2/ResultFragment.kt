package com.example.lab2

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {
    lateinit var outputTextTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val resultFragmentView: View = inflater.inflate(R.layout.result_fragment, container, false)

        outputTextTextView = resultFragmentView.findViewById(R.id.outputTextTextView)

        return resultFragmentView
    }

    fun setOutputText(text: String, typeface: Typeface?) {
        outputTextTextView.text = text
        outputTextTextView.typeface = typeface
    }
}