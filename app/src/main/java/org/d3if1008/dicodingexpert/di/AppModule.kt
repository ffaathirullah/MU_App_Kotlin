package org.d3if1008.dicodingexpert.di

import org.d3if1008.core.domain.usecase.FootballInteractor
import org.d3if1008.core.domain.usecase.FootballUseCase
import org.d3if1008.dicodingexpert.detail.DetailFootballViewModel
import org.d3if1008.dicodingexpert.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<FootballUseCase> { FootballInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailFootballViewModel(get()) }
}