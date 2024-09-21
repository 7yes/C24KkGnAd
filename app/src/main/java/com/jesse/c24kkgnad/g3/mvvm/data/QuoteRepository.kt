package com.jesse.c24kkgnad.g3.mvvm.data

import com.jesse.c24kkgnad.g3.mvvm.data.database.entities.QuoteDao
import com.jesse.c24kkgnad.g3.mvvm.data.database.entities.QuoteEntity
import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import com.jesse.c24kkgnad.g3.mvvm.data.network.QuoteService
import com.jesse.c24kkgnad.g3.mvvm.domain.model.Quote
import com.jesse.c24kkgnad.g3.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val apiService: QuoteService, private val quoteDao: QuoteDao) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = apiService.getAllQuotes()
      //  quoteProvider.quotes = response
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
       val response = quoteDao.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAllQuote(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }

}