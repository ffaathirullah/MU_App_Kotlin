package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel

class FavoriteViewModel(tourismRepository: TourismRepository) : ViewModel() {

    val favoriteTourism = tourismRepository.getFavoriteTourism()

}

