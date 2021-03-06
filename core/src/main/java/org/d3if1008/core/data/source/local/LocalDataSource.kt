package org.d3if1008.core.data.source.local

import kotlinx.coroutines.flow.Flow
import org.d3if1008.core.data.source.local.entity.FootballEntity
import org.d3if1008.core.data.source.local.room.FootballDao


class LocalDataSource(private val footballDao: FootballDao) {

    fun getAllFootball(): Flow<List<FootballEntity>> = footballDao.getAllFootball()

    fun getFavoriteFootball(): Flow<List<FootballEntity>> = footballDao.getFavoriteFootball()

    suspend fun insertFootball(footballList: List<FootballEntity>) = footballDao.insertFootball(footballList)

    fun setFavoriteFootball(football: FootballEntity, newState: Boolean) {
        football.isFavorite = newState
        footballDao.updateFavoriteFootball(football)
    }
}