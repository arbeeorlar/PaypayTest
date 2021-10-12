package com.app.paypay.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Currency(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "countryCode") val countryCode: String?,
    @ColumnInfo(name = "amount") val amount: Double?,
)