package com.jesse.c24kkgnad.g3.mvvm.domain

import com.jesse.c24kkgnad.g3.mvvm.data.QuoteRepository
import com.jesse.c24kkgnad.g3.mvvm.data.database.entities.entity.toDB
import com.jesse.c24kkgnad.g3.mvvm.domain.model.Quote
import javax.inject.Inject

class  GetAllQuotesUC @Inject constructor(private val repository: QuoteRepository){
    suspend operator fun invoke(): List<Quote>
    {
        val quotes: List<Quote> = repository.getAllQuotesFromApi()
        return if (!quotes.isNullOrEmpty()) {
            repository.clearQuotes()
           repository.insertQuotes(quotes.map { it.toDB()})
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }
    }
}
