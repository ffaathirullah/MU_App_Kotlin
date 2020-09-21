package org.d3if1008.dicodingexpert

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballDao {

    @Query("SELECT * FROM football")
    fun getAllFootball(): Flow<List<FootballEntity>>

    @Query("SELECT * FROM football where isFavorite = 1")
    fun getFavoriteFootball(): Flow<List<FootballEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourism(tourism: List<FootballEntity>)

    @Update
    fun updateFavoriteFootball(tourism: FootballEntity)

}
