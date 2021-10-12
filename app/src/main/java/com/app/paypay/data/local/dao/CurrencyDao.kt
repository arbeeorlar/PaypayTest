package com.app.paypay.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.paypay.data.local.entity.Currency


@Dao
interface CurrencyDao {

    @Query("SELECT * FROM Currency")
    suspend fun getAllCurrencies(): List<Currency>

    @Insert
    suspend fun insertAllCurrencies(currencies: List<Currency>)

    @Delete
    suspend fun deleteCurrency(currency: Currency)

}