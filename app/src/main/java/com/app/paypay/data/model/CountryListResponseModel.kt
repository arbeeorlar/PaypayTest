package com.app.paypay.data.model

import com.google.gson.annotations.SerializedName


data class CountryListResponseModel (
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("terms")
    val terms: String,
    @SerializedName("privacy")
    val privacy: String,
    @SerializedName("currencies")
    val currencies: Map<String, Double>
)


