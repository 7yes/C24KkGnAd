package com.jesse.c24kkgnad.g3.mvvm.data.network

import com.jesse.c24kkgnad.g3.mvvm.core.RetrofitHelper
import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getQuotes()
            response.body() ?: emptyList()
        }
    }
}