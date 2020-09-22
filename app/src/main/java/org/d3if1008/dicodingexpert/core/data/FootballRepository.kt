package org.d3if1008.dicodingexpert.core.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.d3if1008.dicodingexpert.core.data.source.local.LocalDataSource
import org.d3if1008.dicodingexpert.core.data.source.remote.RemoteDataSource
import org.d3if1008.dicodingexpert.core.data.source.remote.network.ApiResponse
import org.d3if1008.dicodingexpert.core.data.source.remote.response.FootballResponse
import org.d3if1008.dicodingexpert.core.utils.AppExecutors
import org.d3if1008.dicodingexpert.core.utils.DataMapper
import org.d3if1008.dicodingexpert.domain.model.Football
import org.d3if1008.dicodingexpert.domain.repository.IFootballRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FootballRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IFootballRepository {

    override fun getAllFootball(): Flow<Resource<List<Football>>> =
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

    override fun setFavoriteFootball(football: Football, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(football)
        appExecutors.diskIO().execute { localDataSource.setFavoriteFootball(tourismEntity, state) }
    }
}

