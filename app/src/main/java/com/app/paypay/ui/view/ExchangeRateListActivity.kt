package com.app.paypay.ui.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.paypay.R
import com.app.paypay.data.api.ApiHelper
import com.app.paypay.data.local.DatabaseBuilder
import com.app.paypay.data.local.DatabaseHelperImpl
import com.app.paypay.ui.base.CurrenciesViewModelFactory


import com.app.paypay.ui.main.adapters.CurrencyListAdapter
import com.app.paypay.utils.Status
import com.app.paypay.ui.main.viewModel.CurrenciesViewModel
import com.app.paypay.data.api.ApiServiceImpl
import kotlinx.android.synthetic.main.activity_exchange_rate_list.*

class ExchangeRateListActivity : AppCompatActivity() {

    private lateinit var vm: CurrenciesViewModel
    private lateinit var adapter: CurrencyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_exchange_rate_list)
        setupUI()
        setupViewModel()
        setupObserver()

    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CurrencyListAdapter(mapOf())
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        vm.getCurrencies().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { currencies -> renderList(currencies) }
                   recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                     progressBar.visibility = View.VISIBLE
                     recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(currencies: Map<String,Double>) {
        adapter.addData(currencies)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        vm = ViewModelProviders.of(
            this,
            CurrenciesViewModelFactory(
                ApiHelper(ApiServiceImpl()),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        ).get(CurrenciesViewModel::class.java)

    }
}