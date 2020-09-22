package org.d3if1008.core.di.data.source.local

import kotlinx.coroutines.flow.Flow
import org.d3if1008.core.di.data.source.local.entity.FootballEntity
import org.d3if1008.core.di.data.source.local.room.FootballDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val footballDao: FootballDao) {

    fun getAllFootball(): Flow<List<FootballEntity>> = footballDao.getAllFootball()

    fun getFavoriteFootball(): Flow<List<FootballEntity>> = footballDao.getFavoriteFootball()

    suspend fun insertFootball(footballList: List<FootballEntity>) = footballDao.insertFootball(footballList)

    fun setFavoriteFootball(football: FootballEntity, newState: Boolean) {
        football.isFavorite = newState
        footballDao.updateFavoriteFootball(football)
    }
}