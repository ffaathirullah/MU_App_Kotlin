package org.d3if1008.dicodingexpert.core.data.source.remote.network


import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiConfig {

    fun provideApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/ffaathirullah/json4/master/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)

    }
}