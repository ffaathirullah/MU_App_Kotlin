package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel

class DetaillFootballViewModel(private val footballRepository: FootballRepository) : ViewModel() {
    fun setFavoriteTourism(tourism: FootballEntity, newStatus:Boolean) = footballRepository.setFavoriteTourism(tourism, newStatus)
}

