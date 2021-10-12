package com.app.paypay.data.api


final class ApiHelper(private val apiService : ApiService) {

    fun getCountries() = apiService.getCountries()

    fun getCurrency() = apiService.getCurrencies()
}