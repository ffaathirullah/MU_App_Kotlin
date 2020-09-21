package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import org.d3if1008.dicodingexpert.domain.usecase.FootballUseCase

class HomeViewModel(footballUseCase: FootballUseCase) : ViewModel() {

    val football = footballUseCase.getAllFootball().asLiveData()

}

