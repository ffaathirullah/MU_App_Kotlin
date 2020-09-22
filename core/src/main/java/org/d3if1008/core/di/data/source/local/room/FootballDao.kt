package org.d3if1008.core.di.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.d3if1008.core.di.data.source.local.entity.FootballEntity

@Dao
interface FootballDao {

    @Query("SELECT * FROM football")
    fun getAllFootball(): Flow<List<FootballEntity>>

    @Query("SELECT * FROM football where isFavorite = 1")
    fun getFavoriteFootball(): Flow<List<FootballEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFootball(football: List<FootballEntity>)

    @Update
    fun updateFavoriteFootball(football: FootballEntity)

}
