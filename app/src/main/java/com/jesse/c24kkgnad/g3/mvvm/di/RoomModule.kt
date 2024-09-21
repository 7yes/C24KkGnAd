package com.jesse.c24kkgnad.g3.mvvm.di

import android.content.Context
import androidx.room.Room
import com.jesse.c24kkgnad.g3.mvvm.data.database.entities.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    const val QUOTE_DB_NAME = "quote_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, QuoteDatabase::class.java,
        QUOTE_DB_NAME
    ).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db: QuoteDatabase) = db.quoteDao()
}
