package com.jesse.c24kkgnad.g3.mvvm.data.network

import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET(".json")
    suspend fun getQuotes(): Response<List<QuoteModel>>
}