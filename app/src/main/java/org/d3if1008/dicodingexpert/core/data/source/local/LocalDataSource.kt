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

    fun getAllTourism(): LiveData<List<FootballEntity>> = footballDao.getAllTourism()

    fun getFavoriteTourism(): LiveData<List<FootballEntity>> = footballDao.getFavoriteTourism()

    fun insertTourism(tourismList: List<FootballEntity>) = footballDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: FootballEntity, newState: Boolean) {
        tourism.isFavorite = newState
        footballDao.updateFavoriteTourism(tourism)
    }
}