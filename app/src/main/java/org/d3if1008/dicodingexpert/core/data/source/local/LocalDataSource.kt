package org.d3if1008.dicodingexpert

import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val footballDao: FootballDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(tourismDao: FootballDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(tourismDao)
            }
    }

    fun getAllFootball(): Flow<List<FootballEntity>> = footballDao.getAllFootball()

    fun getFavoriteFootball(): Flow<List<FootballEntity>> = footballDao.getFavoriteFootball()

    suspend fun insertFootball(tourismList: List<FootballEntity>) = footballDao.insertTourism(tourismList)

    fun setFavoriteFootball(tourism: FootballEntity, newState: Boolean) {
        tourism.isFavorite = newState
        footballDao.updateFavoriteFootball(tourism)
    }
}