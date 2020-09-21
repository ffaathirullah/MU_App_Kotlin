package org.d3if1008.dicodingexpert

import androidx.lifecycle.LiveData

class LocalDataSource private constructor(private val footballDao: FootballDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(tourismDao: FootballDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(tourismDao)
            }
    }

    fun getAllFootball(): LiveData<List<FootballEntity>> = footballDao.getAllFootball()

    fun getFavoriteFootball(): LiveData<List<FootballEntity>> = footballDao.getFavoriteTourism()

    fun insertFootball(footballList: List<FootballEntity>) = footballDao.insertFootball(footballList)

    fun setFavoriteFootball(football: FootballEntity, newState: Boolean) {
        football.isFavorite = newState
        footballDao.updateFavoriteFootball(football)
    }
}