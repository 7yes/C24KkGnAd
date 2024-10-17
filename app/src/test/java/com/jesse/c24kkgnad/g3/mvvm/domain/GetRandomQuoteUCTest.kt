package com.jesse.c24kkgnad.g3.mvvm.domain

import com.jesse.c24kkgnad.g3.mvvm.data.QuoteRepository
import com.jesse.c24kkgnad.g3.mvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetRandomQuoteUCTest{

    @RelaxedMockK
    private lateinit var repository: QuoteRepository

    lateinit var getRandomQuoteUC: GetRandomQuoteUC

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuoteUC = GetRandomQuoteUC(repository)
    }

    @Test
    fun `when database is empty then return null`() = runBlocking {
        //Given
        coEvery { repository.getAllQuotesFromDatabase() } returns emptyList()

        //When
        val response = getRandomQuoteUC()

        //Then
        assert(response == null)
    }

    @Test
    fun `when database is not empty then return quote`() = runBlocking {
       val myQuote = listOf(Quote("a", "A", ))
        //Given
        coEvery { repository.getAllQuotesFromDatabase() } returns myQuote
        //When
        val response = getRandomQuoteUC()
        //Then
       coVerify(exactly = 1) { repository.getAllQuotesFromDatabase() }
        assert(response == myQuote.first())
    }

}