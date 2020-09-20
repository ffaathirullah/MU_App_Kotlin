package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel

class FavoriteViewModel(footballRepository: FootballRepository) : ViewModel() {

    val favoriteTourism = footballRepository.getFavoriteFootball()

}

