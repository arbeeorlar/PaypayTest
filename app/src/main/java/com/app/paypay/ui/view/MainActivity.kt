package com.app.paypay.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import com.app.paypay.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

     lateinit var editText :  EditText
     lateinit var string :String

    var languages = arrayOf("USD", "PHP", "Kotlin", "Javascript", "Python", "Swift")
    var languages1 = arrayOf("USD1", "PHP1", "Kotlin1", "Javascript1", "Python1", "Swift1")

    val NEW_SPINNER_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       editText = findViewById<EditText>(R.id.display)

        button0.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}0")

        })

        button1.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}1")

        })
        button2.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}2")

        })
        button3.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}3")

        })
        button4.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}4")

        })
        button5.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}5")

        })
        button6.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}6")

        })
        button7.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}7")

        })
        button8.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}8")

        })
        button9.setOnClickListener(View.OnClickListener {
            editText.setText("${editText.text}9")

        })
        buttonDot.setOnClickListener {
            editText.setText("${editText.text}.")
        }

        BRemain.setOnClickListener{
           string = editText.text.toString() + ""
            Log.i("ERROR:::::",string)
        }


        var arrayAdapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        var arrayAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages1)
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(spinner1){
            adapter = arrayAdapter1
            setSelection(0, false)
            onItemSelectedListener = this@MainActivity
            prompt = "SELECT CURRENCY"
            gravity = Gravity.CENTER
        }

        with(spinner2){
            adapter = arrayAdapter2
            setSelection(0, false)
            onItemSelectedListener = this@MainActivity
            prompt = "SELECT CURRENCY"
            gravity = Gravity.CENTER
        }


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        when (view?.isSelected) {
//             -> ""
//            else -> {
//                showToast(message = "Spinner 1 Position:${position} and language: ${languages[position]}")
//            }
//        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}