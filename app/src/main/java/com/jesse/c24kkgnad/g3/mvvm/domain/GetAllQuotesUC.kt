package com.jesse.c24kkgnad.g3.mvvm.domain

import com.jesse.c24kkgnad.g3.mvvm.data.QuoteRepository
import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import javax.inject.Inject

class  GetAllQuotesUC @Inject constructor(private val repository: QuoteRepository){
    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}
