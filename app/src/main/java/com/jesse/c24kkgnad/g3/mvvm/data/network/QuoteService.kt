package com.jesse.c24kkgnad.g3.mvvm.data.network

import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val apiClient: QuoteApiClient) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getQuotes()
            response.body() ?: emptyList()
        }
    }
}