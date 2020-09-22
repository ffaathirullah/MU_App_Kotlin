package org.d3if1008.dicodingexpert.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import org.d3if1008.core.domain.usecase.FootballUseCase
class FavoriteViewModel(footballUsecase: FootballUseCase) : ViewModel() {

    val favoriteFootball = footballUsecase.getFavoriteFootball().asLiveData()

}

