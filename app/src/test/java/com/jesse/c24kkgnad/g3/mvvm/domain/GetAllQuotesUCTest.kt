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

class GetAllQuotesUCTest {

    @RelaxedMockK
    private lateinit var repository: QuoteRepository

    lateinit var getAllQuotesUC: GetAllQuotesUC

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getAllQuotesUC = GetAllQuotesUC(repository)
    }

    @Test
    fun `when the api dosent return anything then get values from database`() = runBlocking {
        //Given
        coEvery { repository.getAllQuotesFromApi() } returns emptyList()

        //When
        getAllQuotesUC()

        //Then
        coVerify(exactly = 1) { repository.getAllQuotesFromDatabase() }
    }

    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        val myList = listOf(Quote("a", "A", ), Quote("b", "B"))
        //Given
        coEvery { repository.getAllQuotesFromApi() } returns myList

        //When
        val response = getAllQuotesUC()

        //Then
        coVerify(exactly = 1) { repository.clearQuotes() }
        coVerify(exactly = 1) { repository.insertQuotes(any()) }
        coVerify(exactly = 0) { repository.getAllQuotesFromDatabase() }
        assert(response == listOf(Quote("a", "A", ), Quote("b", "B")))
    }
}
