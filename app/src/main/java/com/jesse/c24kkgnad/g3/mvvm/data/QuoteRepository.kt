package com.jesse.c24kkgnad.g3.mvvm.data

import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteProvider
import com.jesse.c24kkgnad.g3.mvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getAllQuotes()
        QuoteProvider.quotes = response
        return response
    }

}