package com.jesse.c24kkgnad.g3.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jesse.c24kkgnad.g3.mvvm.model.QuoteModel
import com.jesse.c24kkgnad.g3.mvvm.model.QuoteProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteVM @Inject constructor():ViewModel() {
    private val _quoteModel = MutableLiveData<QuoteModel>()
    val quoteModel: LiveData<QuoteModel> = _quoteModel

    private val quoteProvider = QuoteProvider()
    fun randomQuote() {
        val currentQuote = quoteProvider.randomQuote
        _quoteModel.postValue(currentQuote)
    }

}