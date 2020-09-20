package org.d3if1008.dicodingexpert

import androidx.lifecycle.ViewModel
import org.d3if1008.dicodingexpert.domain.usecase.FootballUseCase

class HomeViewModel(footballUseCase: FootballUseCase) : ViewModel() {

    val tourism = footballUseCase.getAllFootball()

}

