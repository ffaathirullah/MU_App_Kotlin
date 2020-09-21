package org.d3if1008.dicodingexpert.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if1008.dicodingexpert.FootballDao
import org.d3if1008.dicodingexpert.FootballEntity

@Database(entities = [FootballEntity::class], version = 1, exportSchema = false)
abstract class FootballDatabase : RoomDatabase() {

    abstract fun footballDao(): FootballDao

    companion object {
        @Volatile
        private var INSTANCE: FootballDatabase? = null

        fun getInstance(context: Context): FootballDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FootballDatabase::class.java,
                    "Football.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
    }
}