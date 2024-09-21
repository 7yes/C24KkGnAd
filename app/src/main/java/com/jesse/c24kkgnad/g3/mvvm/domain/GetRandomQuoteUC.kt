package com.jesse.c24kkgnad.g3.mvvm.domain

import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUC @Inject constructor(private val quoteProvider: QuoteProvider){
   // private val quoteRepository = QuoteRepository()

    operator fun invoke() : QuoteModel? {
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            return quotes[(quotes.indices).random()]
        }
        return null
    }
}