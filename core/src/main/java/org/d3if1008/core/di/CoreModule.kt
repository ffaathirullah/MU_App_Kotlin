package org.d3if1008.core.di

import androidx.room.Room
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.d3if1008.core.data.source.local.LocalDataSource
import org.d3if1008.core.data.source.local.room.FootballDatabase
import org.d3if1008.core.data.source.remote.RemoteDataSource
import org.d3if1008.core.data.source.remote.network.ApiService
import org.d3if1008.core.domain.repository.FootballRepository
import org.d3if1008.core.domain.repository.IFootballRepository
import org.d3if1008.core.utils.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<FootballDatabase>().footballDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            FootballDatabase::class.java, "db.json"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/ffaathirullah/json4/master/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IFootballRepository> { FootballRepository(get(), get(), get()) }
}