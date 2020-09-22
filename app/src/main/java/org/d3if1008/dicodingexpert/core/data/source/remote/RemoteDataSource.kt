package org.d3if1008.dicodingexpert.core.data.source.remote

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.d3if1008.dicodingexpert.core.data.source.remote.network.ApiResponse
import org.d3if1008.dicodingexpert.core.data.source.remote.network.ApiService
import org.d3if1008.dicodingexpert.core.data.source.remote.response.FootballResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllFootball(): Flow<ApiResponse<List<FootballResponse>>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.places
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.places))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
            emit(ApiResponse.Error(e.toString()))
            Log.e("RemoteDataSource", e.toString())
        }
        }.flowOn(Dispatchers.IO)
    }
}