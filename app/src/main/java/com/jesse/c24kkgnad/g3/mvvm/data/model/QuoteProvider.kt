package com.jesse.c24kkgnad.g3.mvvm.data.model

import javax.inject.Inject

class QuoteProvider @Inject constructor()  {
    private val quote = listOf<QuoteModel>(
        QuoteModel("The greatest glory in living lies not in never falling, but in rising every time we fall.", "Nelson Mandela"),
        QuoteModel("The way to get started is to quit talking and begin doing.", "Walt Disney"),
        QuoteModel("If life were predictable it would cease to be life, and be without flavor.", "Eleanor Roosevelt"),
    )
    val randomQuote = quote.random()
}