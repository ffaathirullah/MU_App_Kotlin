package org.d3if1008.dicodingexpert.core.data.source.remote.network

import org.d3if1008.dicodingexpert.core.data.source.remote.response.ListFootballResponse
import retrofit2.http.GET

interface ApiService {
    @GET("db.json")

    suspend  fun getList(): ListFootballResponse
}