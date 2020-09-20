package org.d3if1008.dicodingexpert

import android.content.Context

object Injection {
    fun provideRepository(context: Context): FootballRepository {
        val database = FootballDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.footballDao())
        val appExecutors = AppExecutors()

        return FootballRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
