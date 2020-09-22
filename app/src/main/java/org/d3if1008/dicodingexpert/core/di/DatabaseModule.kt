package org.d3if1008.dicodingexpert.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import org.d3if1008.dicodingexpert.core.data.source.local.room.FootballDao
import org.d3if1008.dicodingexpert.core.data.source.local.room.FootballDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): FootballDatabase = Room.databaseBuilder(
        context,
        FootballDatabase::class.java, "Tourism.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideTourismDao(database: FootballDatabase): FootballDao = database.footballDao()
}