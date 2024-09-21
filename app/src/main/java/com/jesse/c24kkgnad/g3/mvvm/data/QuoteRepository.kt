package com.jesse.c24kkgnad.g3.mvvm.data

import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteProvider
import com.jesse.c24kkgnad.g3.mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val apiService: QuoteService, private val quoteProvider: QuoteProvider) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = apiService.getAllQuotes()
        quoteProvider.quotes = response
        return response
    }

}