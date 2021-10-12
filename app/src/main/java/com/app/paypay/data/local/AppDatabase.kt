package com.app.paypay.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.paypay.data.local.dao.CurrencyDao
import com.app.paypay.data.local.entity.Currency


@Database(entities = [Currency::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao

}