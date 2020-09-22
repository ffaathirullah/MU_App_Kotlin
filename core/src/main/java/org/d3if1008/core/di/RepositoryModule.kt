package org.d3if1008.core.di

import dagger.Binds
import dagger.Module
import org.d3if1008.core.domain.repository.FootballRepository
import org.d3if1008.core.domain.repository.IFootballRepository

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: FootballRepository): IFootballRepository

}