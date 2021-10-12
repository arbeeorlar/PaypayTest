package com.app.paypay.data.local

import com.app.paypay.data.local.entity.Currency


interface DatabaseHelper {

    suspend fun getUsers(): List<Currency>

    suspend fun insertAll(users: List<Currency>)

}