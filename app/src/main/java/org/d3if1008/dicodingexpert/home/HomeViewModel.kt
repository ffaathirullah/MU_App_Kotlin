package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel

class HomeViewModel(footballRepository: FootballRepository) : ViewModel() {

    val tourism = footballRepository.getAllTourism()

}

