package com.jesse.c24kkgnad.g3.mvvm.domain

import com.jesse.c24kkgnad.g3.mvvm.data.QuoteRepository
import com.jesse.c24kkgnad.g3.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUC @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke() : Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            return quotes[(quotes.indices).random()]
        }
        return null
    }
}