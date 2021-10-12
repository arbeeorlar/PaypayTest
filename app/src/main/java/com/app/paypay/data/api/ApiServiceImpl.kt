package com.app.paypay.data.api

import com.app.paypay.data.model.CountryListResponseModel
import com.app.paypay.data.model.CurrencyListResponseModel
import com.app.paypay.utils.Constants
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single



class ApiServiceImpl : ApiService {
    override fun getCurrencies(): Single<CurrencyListResponseModel> {
        return Rx2AndroidNetworking.get("${Constants.currencyURL}")
            .build()
            .getObjectSingle(CurrencyListResponseModel::class.java)
    }

    override fun getCountries(): Single<CountryListResponseModel> {
        return Rx2AndroidNetworking.get("${Constants.countryURL}")
            .build()
            .getObjectSingle(CountryListResponseModel::class.java)
    }

}