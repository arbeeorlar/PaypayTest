//package com.app.paypay.ui.base
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.app.paypay.data.api.ApiHelper
//import com.app.paypay.data.repository.MainRepository
//
//
//class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
//
//
//
////    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
////        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
////            return MainViewModel(MainRepository(apiHelper)) as T
////        }
////        throw IllegalArgumentException("Unknown class name")
////    }
//}