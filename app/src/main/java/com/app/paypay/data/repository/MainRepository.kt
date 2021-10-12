package com.app.paypay.data.repository

import com.app.paypay.data.api.ApiHelper
import com.app.paypay.data.model.CountryListResponseModel
import com.app.paypay.data.model.CurrencyListResponseModel
import io.reactivex.Single


class MainRepository(private val apiHelper : ApiHelper) {

    fun getCurrencies(): Single<CurrencyListResponseModel> {
        return apiHelper.getCurrency()
    }

    fun getCountries(): Single<CountryListResponseModel> {
        return apiHelper.getCountries()
    }
}