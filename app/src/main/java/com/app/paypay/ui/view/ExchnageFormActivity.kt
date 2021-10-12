package com.app.paypay.ui.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.annotation.RequiresApi
import com.app.paypay.R
import com.app.paypay.databinding.ActivityExchnageFormBinding
import kotlinx.android.synthetic.main.activity_exchnage_form.*

class ExchnageFormActivity : AppCompatActivity() {

   private var converterAmount : Double = 0.0
    private var countryDescription : String = ""
    private var countryCode : String = ""

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }

        setContentView(R.layout.activity_exchnage_form)
        converterAmount  = intent.getDoubleExtra("amount",0.0)

        back.setOnClickListener{
            finish()
        }

        displayResult.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if(s.toString().isNotEmpty()){ // DecimalFormat("#,###.00")
                    var amt = converterAmount * s.toString().toDouble().dec()
                    convertedCurrency.text = "${intent.getStringExtra("countryCode").toString()} $amt"
                }

            }
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                if(s.toString().isNotEmpty()){
                    var amt = converterAmount * s.toString().toDouble().dec()
                    convertedCurrency.text = "${intent.getStringExtra("countryCode").toString()} $amt"
                }

            }
        })

       // binding.
    }
}