package org.d3if1008.dicodingexpert.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if1008.dicodingexpert.detail.DetailFootballViewModel
import org.d3if1008.dicodingexpert.di.AppScope
import org.d3if1008.dicodingexpert.domain.usecase.FootballUseCase
import org.d3if1008.dicodingexpert.favorite.FavoriteViewModel
import org.d3if1008.dicodingexpert.home.HomeViewModel
import javax.inject.Inject

@AppScope
class ViewModelFactory @Inject constructor(private val footballUsecase: FootballUseCase) :
    ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(footballUsecase) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(footballUsecase) as T
            }
            modelClass.isAssignableFrom(DetailFootballViewModel::class.java) -> {
                DetailFootballViewModel(footballUsecase) as T
            }
            else -> throw Throwable("ViewModel class: " + modelClass.name)
        }
}