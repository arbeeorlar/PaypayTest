package com.app.paypay.ui.base

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.paypay.data.api.ApiHelper
import com.app.paypay.data.local.DatabaseHelper
import com.app.paypay.data.repository.MainRepository
import com.app.paypay.ui.main.viewModel.CurrenciesViewModel



class CurrenciesViewModelFactory(private val apiHelper: ApiHelper,private val dbHelper: DatabaseHelper) : ViewModelProvider.Factory {



    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CurrenciesViewModel::class.java)) {
            return CurrenciesViewModel(MainRepository(apiHelper),dbHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }


}