package com.app.paypay.data.local

import android.content.SharedPreferences




class SharedPreferencesHelper(sharedPreferences: SharedPreferences) {

    private var mSharedPreferences: SharedPreferences? = null

    init {
        mSharedPreferences = sharedPreferences
    }

    fun SharedPreferencesHelper(sharedPreferences: SharedPreferences?) {
        mSharedPreferences = sharedPreferences
    }


    fun setString(key : String,value : String): Boolean {
        // Start a SharedPreferences transaction.
        val editor = mSharedPreferences!!.edit()
        editor.putString(key, value)
        return editor.commit()
    }

    fun getString(key: String): String? = mSharedPreferences!!.getString(key, "")
}