package org.d3if1008.dicodingexpert

import com.dicoding.tourismapp.core.data.source.remote.response.FootballResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.d3if1008.dicodingexpert.domain.model.Football
import org.d3if1008.dicodingexpert.domain.repository.IFootballRepository

class FootballRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IFootballRepository {

    companion object {
        @Volatile
        private var instance: FootballRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): FootballRepository =
            instance ?: synchronized(this) {
                instance ?: FootballRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllFootball(): Flow<org.d3if1008.dicodingexpert.Resource<List<Football>>> =
        object : NetworkBoundResource<List<Football>, List<FootballResponse>>() {
            override fun loadFromDB(): Flow<List<Football>> {
                return localDataSource.getAllFootball().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Football>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<FootballResponse>>> =
                remoteDataSource.getAllFootball()

            override suspend fun saveCallResult(data: List<FootballResponse>) {
                val footballList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertFootball(footballList)
            }
    }.asFlow()

    override fun getFavoriteFootball(): Flow<List<Football>> {
        return localDataSource.getFavoriteFootball().map { DataMapper.mapEntitiesToDomain(it) }

    }

    override fun setFavoriteFootball(tourism: Football, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteFootball(tourismEntity, state) }
    }
}

