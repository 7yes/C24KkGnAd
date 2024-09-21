package com.jesse.c24kkgnad.g3.mvvm.data.model

import javax.inject.Inject

class QuoteProvider @Inject constructor() {
    companion object {
        var quotes: List<QuoteModel> = emptyList()
    }
}
