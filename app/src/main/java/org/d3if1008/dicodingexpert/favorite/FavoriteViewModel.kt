package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel
import org.d3if1008.dicodingexpert.domain.usecase.FootballUseCase

class FavoriteViewModel(footballUsecase: FootballUseCase) : ViewModel() {

    val favoriteTourism = footballUsecase.getFavoriteFootball()

}

