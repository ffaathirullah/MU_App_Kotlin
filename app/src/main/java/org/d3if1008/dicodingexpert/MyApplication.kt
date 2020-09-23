package org.d3if1008.dicodingexpert

import android.app.Application
import org.d3if1008.core.di.databaseModule
import org.d3if1008.core.di.networkModule
import org.d3if1008.core.di.repositoryModule
import org.d3if1008.dicodingexpert.di.useCaseModule
import org.d3if1008.dicodingexpert.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}