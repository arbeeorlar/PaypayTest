package com.app.paypay.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.app.paypay.R
import com.app.paypay.databinding.ActivityExchangeBinding
import kotlinx.android.synthetic.main.activity_exchange.*


class ExchangeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityExchangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_exchange)
        button.setOnClickListener {
            startActivity(Intent(applicationContext,ExchangeRateListActivity::class.java))
        }



    }


}