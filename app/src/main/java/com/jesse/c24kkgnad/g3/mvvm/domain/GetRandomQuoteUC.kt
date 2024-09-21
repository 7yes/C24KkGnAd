package com.jesse.c24kkgnad.g3.mvvm.domain

import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteProvider

class GetRandomQuoteUC {
   // private val quoteRepository = QuoteRepository()

    operator fun invoke() : QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            return quotes[(quotes.indices).random()]
        }
        return null
    }
}