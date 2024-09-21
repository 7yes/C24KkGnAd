package com.jesse.c24kkgnad.g3.mvvm.domain.model

import com.jesse.c24kkgnad.g3.mvvm.data.database.entities.QuoteEntity
import com.jesse.c24kkgnad.g3.mvvm.data.model.QuoteModel

data class Quote (
    val quote: String,
    val author: String
)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)