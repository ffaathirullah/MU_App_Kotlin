package org.d3if1008.dicodingexpert

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.dicoding.tourismapp.core.data.source.remote.response.FootballResponse
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

    override fun getAllFootball(): LiveData<Resource<List<Football>>> =
        object : NetworkBoundResource<List<Football>, List<FootballResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Football>> {
                return Transformations.map(localDataSource.getAllFootball()) {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Football>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<FootballResponse>>> =
                remoteDataSource.getAllFootball()

            override fun saveCallResult(data: List<FootballResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertFootball(tourismList)
            }
        }.asLiveData()

    override fun getFavoriteFootball(): LiveData<List<Football>> {
        return Transformations.map(localDataSource.getFavoriteFootball()) {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteFootball(tourism: Football, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteFootball(tourismEntity, state) }
    }
}

