package org.d3if1008.dicodingexpert

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.concurrent.Flow

@Dao
interface FootballDao {

    @Query("SELECT * FROM football")
    fun getAllFootball(): LiveData<List<FootballEntity>>

    @Query("SELECT * FROM football where isFavorite = 1")
    fun getFavoriteTourism(): LiveData<List<FootballEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFootball(tourism: List<FootballEntity>)

    @Update
    fun updateFavoriteFootball(football: FootballEntity)

}
