package org.d3if1008.dicodingexpert.detail

import androidx.lifecycle.ViewModel
import org.d3if1008.core.domain.model.Football
import org.d3if1008.core.domain.usecase.FootballUseCase


class DetailFootballViewModel(private val footballUseCase: FootballUseCase) : ViewModel() {
    fun setFavoriteFootball(football: Football, newStatus:Boolean) = footballUseCase.setFavoriteFootball(football, newStatus)
}

