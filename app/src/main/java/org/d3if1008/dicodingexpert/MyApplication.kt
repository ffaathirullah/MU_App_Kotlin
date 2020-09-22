package org.d3if1008.dicodingexpert

import android.app.Application
import org.d3if1008.core.di.CoreComponent
import org.d3if1008.core.di.DaggerCoreComponent
import org.d3if1008.dicodingexpert.di.AppComponent
import org.d3if1008.dicodingexpert.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}