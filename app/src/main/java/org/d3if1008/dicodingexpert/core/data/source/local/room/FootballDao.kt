package org.d3if1008.dicodingexpert

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FootballDao {

    @Query("SELECT * FROM football")
    fun getAllTourism(): LiveData<List<FootballEntity>>

    @Query("SELECT * FROM football where isFavorite = 1")
    fun getFavoriteTourism(): LiveData<List<FootballEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTourism(tourism: List<FootballEntity>)

    @Update
    fun updateFavoriteTourism(tourism: FootballEntity)
}
