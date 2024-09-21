package com.jesse.c24kkgnad.g3.mvvm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import com.jesse.c24kkgnad.g3.mvvm.domain.GetAllQuotesUC
import com.jesse.c24kkgnad.g3.mvvm.domain.GetRandomQuoteUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteVM @Inject constructor(private val getAllQuotesUC: GetAllQuotesUC, private val getRandomQuoteUC: GetRandomQuoteUC) : ViewModel() {
    private val _quoteModel = MutableLiveData<QuoteModel>()
    val quoteModel: LiveData<QuoteModel> = _quoteModel
    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean> = _isLoading

    fun onCreate() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            val result = getAllQuotesUC()
            if (!result.isNullOrEmpty()) {
                _quoteModel.postValue(result[0])
            }
            _isLoading.postValue(false)
        }
    }


    fun randomQuote() {
        _isLoading.postValue(true)
          val currentQuote: QuoteModel? = getRandomQuoteUC()
        if(currentQuote!=null){
            _quoteModel.postValue(currentQuote!!)
        }
        _isLoading.postValue(false)
    }

}