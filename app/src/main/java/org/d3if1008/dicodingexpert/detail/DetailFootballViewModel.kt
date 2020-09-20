package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel
import org.d3if1008.dicodingexpert.domain.model.Football
import org.d3if1008.dicodingexpert.domain.usecase.FootballUseCase

class DetailFootballViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {
    fun setFavoriteFootball(football: Football, newStatus:Boolean) = footballUseCase.setFavoriteFootball(football, newStatus)
}

