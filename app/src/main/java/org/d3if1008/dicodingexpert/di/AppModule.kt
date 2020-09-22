package org.d3if1008.dicodingexpert.di

import dagger.Binds
import dagger.Module
import org.d3if1008.core.domain.usecase.FootballInteractor
import org.d3if1008.core.domain.usecase.FootballUseCase

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(footballInteractor: FootballInteractor): FootballUseCase

}