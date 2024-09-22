package com.jesse.c24kkgnad.g3.mvvm.data.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jesse.c24kkgnad.g3.mvvm.data.database.entities.dao.QuoteDao
import com.jesse.c24kkgnad.g3.mvvm.data.database.entities.entity.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun quoteDao(): QuoteDao
}