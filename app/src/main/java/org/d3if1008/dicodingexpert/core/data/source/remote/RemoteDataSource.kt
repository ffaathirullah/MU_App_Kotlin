package org.d3if1008.dicodingexpert

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.tourismapp.core.data.source.remote.response.FootballResponse
import org.d3if1008.dicodingexpert.core.data.source.remote.network.ApiService
import org.d3if1008.dicodingexpert.core.data.source.remote.response.ListFootballResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllTourism(): LiveData<ApiResponse<List<FootballResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<FootballResponse>>>()

        //get data from remote api
        val client = apiService.getList()
        client.enqueue(object : Callback<ListFootballResponse> {
            override fun onResponse(
                call: Call<ListFootballResponse>,
                response: Response<ListFootballResponse>
            ) {
                val dataArray = response.body()?.places
                resultData.value =
                    if (dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListFootballResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource", t.message.toString())
            }
        })

        return resultData
    }
}