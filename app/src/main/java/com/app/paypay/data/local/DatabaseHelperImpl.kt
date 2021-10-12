package com.app.paypay.data.local

import com.app.paypay.data.local.entity.Currency


class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getUsers(): List<Currency> = appDatabase.currencyDao().getAllCurrencies()

    override suspend fun insertAll(currencyModel: List<Currency>) = appDatabase.currencyDao().insertAllCurrencies(currencyModel)

}