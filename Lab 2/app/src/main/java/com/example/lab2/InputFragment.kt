package com.example.lab2

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {
    private lateinit var enteredTextListener: EnteredTextListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            enteredTextListener = context as EnteredTextListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnArticleSelectedListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val inputFragmentView: View =  inflater.inflate(R.layout.input_fragment, container, false)

        val radioGroup: RadioGroup = inputFragmentView.findViewById(R.id.radioGroup)
        val enterTextTextView: TextView = inputFragmentView.findViewById(R.id.enterTextEditText)
        val okButton: Button = inputFragmentView.findViewById(R.id.okButton)
        val cancelButton: Button = inputFragmentView.findViewById(R.id.cancelButton)

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
                val toast = Toast.makeText(requireActivity().application, "Empty string", Toast.LENGTH_SHORT)
                toast.show()
            } else {
                enteredTextListener.enteredText("${enterTextTextView.text}", typeface)
            }
        }

        cancelButton.setOnClickListener {
            enteredTextListener.enteredText("", null)
        }

        return inputFragmentView
    }
}