package com.example.lab3

import android.content.Context
import android.content.Intent
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
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream

class InputFragment : Fragment() {
    private lateinit var enteredTextListener: EnteredTextListener

    private val fileName: String = "textData.txt"

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
        val openButton: Button = inputFragmentView.findViewById(R.id.openButton)

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
                val enteredText: String = "${enterTextTextView.text}"
                enteredTextListener.enteredText(enteredText, typeface)

                try {
                    val fileOutputStream: FileOutputStream = requireActivity().openFileOutput(fileName, Context.MODE_PRIVATE)
                    fileOutputStream.write(enteredText.toByteArray())
                    fileOutputStream.close()

                    val toast = Toast.makeText(requireActivity().application, "Writing is successful", Toast.LENGTH_SHORT)
                    toast.show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        cancelButton.setOnClickListener {
            enteredTextListener.enteredText("", null)
        }

        openButton.setOnClickListener {
            var fileInputStream: FileInputStream? = null

            try {
                fileInputStream = requireActivity().openFileInput(fileName)

                val byteArray: ByteArray = ByteArray(fileInputStream.available())

                fileInputStream.read(byteArray)
                fileInputStream?.close()

                val textData: String = String(byteArray)

                val intent: Intent = Intent(requireActivity(), DataActivity::class.java)
                intent.putExtra("textData", textData)
                startActivity(intent)
            } catch (e: FileNotFoundException) {
                val toast = Toast.makeText(requireActivity().application, "File not found", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        return inputFragmentView
    }
}