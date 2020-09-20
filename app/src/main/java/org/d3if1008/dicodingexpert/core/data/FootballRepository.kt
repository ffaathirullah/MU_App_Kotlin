package org.d3if1008.dicodingexpert

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.source.remote.response.FootballResponse

class FootballRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) {

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

    fun getAllTourism(): LiveData<Resource<List<FootballEntity>>> =
        object : NetworkBoundResource<List<FootballEntity>, List<FootballResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<FootballEntity>> {
                return localDataSource.getAllTourism()
            }

            override fun shouldFetch(data: List<FootballEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<FootballResponse>>> =
                remoteDataSource.getAllTourism()

            override fun saveCallResult(data: List<FootballResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asLiveData()

    fun getFavoriteTourism(): LiveData<List<FootballEntity>> {
        return localDataSource.getFavoriteTourism()
    }

    fun setFavoriteTourism(tourism: FootballEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourism, state) }
    }
}

