package com.app.paypay.data.api

import com.app.paypay.data.model.CountryListResponseModel
import com.app.paypay.data.model.CurrencyListResponseModel
import io.reactivex.Single



interface ApiService {

   fun getCurrencies(): Single<CurrencyListResponseModel>

    fun getCountries(): Single<CountryListResponseModel>
}