package com.app.paypay.ui.main.viewModel

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.paypay.data.local.DatabaseHelper
import com.app.paypay.data.local.SharedPreferencesHelper
import com.app.paypay.data.local.entity.Currency
import com.app.paypay.data.repository.MainRepository
import com.app.paypay.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class CurrenciesViewModel(private val mainRepository: MainRepository,private val dbHelper: DatabaseHelper) : ViewModel() {

    private val currency = MutableLiveData<Resource<Map<String, Double>>>()
    private val compositeDisposable = CompositeDisposable()



    init {
        fetchCurrencies()
    }




    private fun fetchCurrencies() {
        currency.postValue(Resource.loading(null))
        try{
            compositeDisposable.add(
                mainRepository.getCurrencies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ currencyList ->
                        var key = currencyList.quotes.keys
                        var value = currencyList.quotes.values
                        currency.postValue(Resource.success(currencyList.quotes))
                    }, {
                        currency.postValue(Resource.error("Something Went Wrong", null))
                    })
            )
        }catch (ex : Exception){
            currency.postValue(Resource.error("$ex", null))
        }

    }



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getCurrencies(): LiveData<Resource<Map<String, Double>>> {
        return currency
    }



}