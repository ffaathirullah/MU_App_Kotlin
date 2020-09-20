package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel

class HomeViewModel(tourismRepository: TourismRepository) : ViewModel() {

    val tourism = tourismRepository.getAllTourism()

}

