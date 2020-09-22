package org.d3if1008.core.di.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import org.d3if1008.core.di.data.source.local.entity.FootballEntity

@Database(entities = [FootballEntity::class], version = 1, exportSchema = false)
abstract class FootballDatabase : RoomDatabase() {

    abstract fun footballDao(): FootballDao

}