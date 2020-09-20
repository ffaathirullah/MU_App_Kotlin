package org.d3if1008.dicodingexpert

import android.content.Context
import org.d3if1008.dicodingexpert.domain.repository.IFootballRepository
import org.d3if1008.dicodingexpert.domain.usecase.FootballInteractor
import org.d3if1008.dicodingexpert.domain.usecase.FootballUseCase

object Injection {
    fun provideFootballUseCase(context: Context): FootballUseCase {
        val repository = Injection.provideRepository(context)
        return FootballInteractor(repository)
    }

    object Injection {
        fun provideRepository(context: Context): IFootballRepository {
            val database = FootballDatabase.getInstance(context)

            val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
            val localDataSource = LocalDataSource.getInstance(database.footballDao())
            val appExecutors = AppExecutors()

            return FootballRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
        }

    }
}
