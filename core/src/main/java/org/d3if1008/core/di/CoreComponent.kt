package org.d3if1008.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import org.d3if1008.core.domain.repository.IFootballRepository
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository() : IFootballRepository
}