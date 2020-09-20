package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel
import org.d3if1008.dicodingexpert.domain.model.Football

class DetailFootballViewModel(private val footballRepository: FootballRepository) : ViewModel() {
    fun setFavoriteFootball(football: Football, newStatus:Boolean) = footballRepository.setFavoriteFootball(football, newStatus)
}

